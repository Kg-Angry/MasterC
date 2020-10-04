package master.springExtractor.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import java.util.Iterator;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

@RestController
@RequestMapping(value = "api/multipartFileHandler")
public class MultipartFileHandlerController {
	int brojac = 0;
	public List<String> criteriaList = new ArrayList<String>();
	String tableName = "results.xls";
	
	//cuvanje upload-ovane bodovne skale na serveru
	private String saveUploadedCriteria(MultipartFile file) throws IOException {

		String orgName = file.getOriginalFilename();
	    if (!file.isEmpty()) {
			Path currentWorkingDir = Paths.get("").toAbsolutePath();
			String path = currentWorkingDir.normalize().toString()+"/src/main/resources/files/";

			if (!new File(path).exists()) {
				new File(path).mkdir();
			}

			String filePath = path + orgName;

			File dest = new File(filePath);
			file.transferTo(dest);
		    System.out.println("\n\t\tBodovna skala sacuvana na putanji:\t" + filePath + "\n");
	    }
	            
	    return orgName;
	}

	//dodavanje skroz popunjene excel tabele za konvert PDF (deo se pretvara u pdf)
	@RequestMapping(value = "/parseUploadedExcel", method = RequestMethod.POST)
	public ResponseEntity<?> parseUploadedExcel(@PathVariable MultipartFile file) throws IOException, DocumentException {
		String fileName = saveUploadedCriteria(file);
		
		Path currentWorkingDir = Paths.get("").toAbsolutePath();
		String path = currentWorkingDir.normalize().toString()+"/src/main/resources/files/";
		
		FileInputStream input_document = new FileInputStream(path + "results.xls");
        // Read workbook into HSSFWorkbook
        HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document); 
        // Read worksheet into HSSFSheet
        HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0); 
        // To iterate over the rows
        Iterator<Row> rowIterator = my_worksheet.iterator();
        //We will create output PDF document objects at this point
        Document iText_xls_2_pdf = new Document();
        PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("results"+brojac+".pdf"));
        iText_xls_2_pdf.open();
        //we have two columns in the Excel sheet, so we create a PDF table with two columns
        //Note: There are ways to make this dynamic in nature, if you want to.
        PdfPTable my_table = new PdfPTable(3);
        //We will use the object below to dynamically add new data to the table
        PdfPCell table_cell;
        
        
        //Loop through rows.
        while(rowIterator.hasNext()) {
                Row row = rowIterator.next(); 
                Iterator<Cell> cellIterator = row.cellIterator();
                int counter = 0;
                
                        while(cellIterator.hasNext()) {
                        	counter++;
                        	
                        	if(counter <= 3) {
                        	
                                Cell cell = cellIterator.next(); //Fetch CELL
                                
                                switch(cell.getCellType()) { //Identify CELL type
                                        //you need to add more code here based on
                                        //your requirement / transformations
                                case Cell.CELL_TYPE_STRING:
                                        //Push the data from Excel to PDF Cell
                                         table_cell=new PdfPCell(new Phrase(cell.getStringCellValue()));
                                         //feel free to move the code below to suit to your needs
                                         my_table.addCell(table_cell);
                                        break;
                                case Cell.CELL_TYPE_FORMULA:
                                    //Push the data from Excel to PDF Cell   
                                	 cell.setCellType(Cell.CELL_TYPE_STRING);
                                     table_cell=new PdfPCell(new Phrase(cell.getStringCellValue()));
                                     //feel free to move the code below to suit to your needs
                                     my_table.addCell(table_cell);
                                    break;
                                }
                                //next line
                            } else 
                            	break;
                        }

        }
        
        //Finally add the table to PDF document
        iText_xls_2_pdf.add(my_table);                       
        iText_xls_2_pdf.close();                
        //we created our pdf file..
        input_document.close(); //close xls
        
        String p2 = currentWorkingDir.normalize().toString()+"/results"+brojac+".pdf";
        brojac++;
		
        Path path2 = Paths.get(p2);
        Resource resource = null;
    	try {
    		resource = new UrlResource(path2.toUri());
    	} catch (MalformedURLException e) {
    		e.printStackTrace();
    	}
    	return ResponseEntity.ok()
    			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
    			.body(resource);
    	
	}
	
	
	
	//parsiranje fajla sa bodovnom skalom
	@RequestMapping(value = "/parseUploadedCriteria", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> parseUploadedCriteria(@PathVariable MultipartFile file) throws IOException {
		String fileName = saveUploadedCriteria(file);
		
		BufferedReader in = null;
		String line;
		int lineNumber = 0;
		
		try {
			in = new BufferedReader(new FileReader("src/main/resources/files/" + fileName));
			while ((line = in.readLine()) != null) {
				if(lineNumber == 0) { //preskoci prvu liniju - max bodovi za odabrani test
					lineNumber++;
					continue;
				}
				criteriaList.add(line.trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } finally {
            if(in != null){
                try {
                    in.close();                    
                    createExcelTable();
                    return new ResponseEntity<>(HttpStatus.OK);
                } catch (Exception e) {
        			e.printStackTrace();
        			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            }
        }
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	private void createExcelTable() throws IOException {	
		try {
			Path currentWorkingDir = Paths.get("").toAbsolutePath();
			String path = currentWorkingDir.normalize().toString()+"/src/main/resources/student/home/provera/" + tableName;
			String path1 = currentWorkingDir.normalize().toString()+"/src/main/resources/exctracted";
			
			
			FileOutputStream out = new FileOutputStream(path);
			Workbook wb = new HSSFWorkbook();
			Sheet s = wb.createSheet();
			wb.setSheetName(0, "results");
			
			Row r = null;
			Cell c;
			Cell computer = null;
			Cell student = null;
			Cell points = null;
			
			CellStyle csHeader = wb.createCellStyle();
			Font fHeader = wb.createFont();
			fHeader.setColor((short)Font.COLOR_RED);
			fHeader.setBoldweight(Font.BOLDWEIGHT_BOLD);
			fHeader.setItalic(true);
			csHeader.setFont(fHeader);
			csHeader.setAlignment(CellStyle.ALIGN_CENTER);
			
			r = s.createRow(0);	
			
			computer = r.createCell(0);
			computer.setCellValue("racunar:");
			computer.setCellStyle(csHeader);
			s.setColumnWidth(0, 10 * 256);
			
			student = r.createCell(1);
			student.setCellValue("student:");
			student.setCellStyle(csHeader);
			s.setColumnWidth(1, 40 * 256);
			
			points = r.createCell(2);
			points.setCellValue("UKUPNO:");
			points.setCellStyle(csHeader);
			s.setColumnWidth(2, 10 * 256);
			
			for (int i = 0; i < criteriaList.size(); i++) {
				s.setColumnWidth(i+1+2, 65 * 256);
				c = r.createCell(i+1+2);
				c.setCellValue(criteriaList.get(i));
				c.setCellStyle(csHeader);
			}
			
			spisakStudenata(new File(path1),computer,student,r,s);
			try {
				wb.write(out);
				System.out.println("\t\tTabela je uspesno sacuvana!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void spisakStudenata(File files, Cell computer, Cell std, Row r,Sheet s) throws IOException
	{
		String line;
		BufferedReader in = null;
		Cell c=null;
		if(files.isDirectory())
		{
			for(File f : files.listFiles())
			{
				String[] split = f.getName().split("\\.");
				if(split.length > 2)
				{
					in = new BufferedReader(new FileReader("src/main/resources/exctracted/" + f.getName()));
					int counter = 0;
					int counterFormula = 0;
					while ((line = in.readLine()) != null) {
						counter++;
						String[] text = line.split(",");
						String racunar = text[0].trim();
						String student = text[1].trim()+" "+text[2].trim();
						
						r = s.createRow(counter);
						
						//dodat racunar
						s.setColumnWidth(0, 10 * 256);
						c = r.createCell(0);
						c.setCellValue(racunar);
						
						//dodat student
						s.setColumnWidth(1, 45 * 256);
						c = r.createCell(1);
						c.setCellValue(student);
						
						//bodovi
						s.setColumnWidth(2, 10 * 256);
						c = r.createCell(2);
						counterFormula = counter + 1;
						c.setCellFormula("SUM(D" + counterFormula + ":" + "M" + counterFormula + ")"); //zakucano :(
						c.setCellValue(0);						
					}
				}
				
			}
		}
		
	}
}

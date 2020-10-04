package master.springExtractor.controller;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value = "api/multipartFileWorksHandler")
public class MultipartFileWorksHandlerController {
	
	private ArrayList<String> fileList;
	
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
	
		//parsiranje fajla sa bodovnom skalom
		@RequestMapping(value = "/parseUploadedWorks", method = RequestMethod.POST)
		public ResponseEntity<HttpStatus> parseUploadedCriteria(@PathVariable MultipartFile file) throws IOException {

			String fileName = saveUploadedCriteria(file);
			
			try {
				readTarFile(fileName,"");
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        } 
			
		}	
		
	public void readTarFile(String file_name,String putanja) throws IOException
	{
		
		if(putanja.equals(""))
		{
			File f = new File("src/main/resources/files/" + file_name);
			TarArchiveInputStream myTarFile= new TarArchiveInputStream(new FileInputStream("src/main/resources/files/" + file_name));
	        /* To read individual TAR file */
	        TarArchiveEntry entry = null;
	        String individualFiles;
	        int offset;
	        FileOutputStream outputFile=null;
	        /* Create a loop to read every single entry in TAR file */
	        while ((entry = myTarFile.getNextTarEntry()) != null) {
	                /* Get the name of the file */
	                individualFiles = entry.getName();
	                /* Define OutputStream for writing the file */
	                outputFile=new FileOutputStream(new File("src/main/resources/exctracted/" + individualFiles));
	                /* Use IOUtiles to write content of byte array to physical file */
	                IOUtils.copy(myTarFile,outputFile);              
	                /* Close Output Stream */
	                outputFile.close();
	                
	        }               
	        /* Close TarAchiveInputStream */
	        myTarFile.close();
	        listTarFile();
		}else
		{
			File f = new File(putanja +"/"+ file_name);
			Path currentWorkingDir = Paths.get("").toAbsolutePath();
			try (TarArchiveInputStream fin = new TarArchiveInputStream(new GzipCompressorInputStream(new FileInputStream(putanja +"/"+ file_name)))){
	            TarArchiveEntry entry;
	            while ((entry = fin.getNextTarEntry()) != null) {
	            	if (entry.isDirectory()) {
	                    continue;
	                }
	                File curfile = new File(currentWorkingDir.normalize().toString()+"/src/main/resources/student/", entry.getName());
	                File parent = curfile.getParentFile();
	                if (!parent.exists()) {
	                    parent.mkdirs();
	                }
	                
	                IOUtils.copy(fin, new FileOutputStream(curfile));
	                
	            }
	        }
		}
	}
	
	public void listTarFile() throws IOException
	{
		Path currentWorkingDir = Paths.get("").toAbsolutePath();
		String path = currentWorkingDir.normalize().toString()+"/src/main/resources/exctracted";
		File folder = new File(path);
			for (File fileEntry : folder.listFiles()) {
				System.out.println("FILE JE : " + fileEntry.getName());
		        String[] split = fileEntry.getName().split("\\.");
		        if(split[1].equals("tgz"))
		        {
		        	
		        	readTarFile(fileEntry.getName(),path);
		        	
		        }
		    }
	}
	
	@RequestMapping(value="/download",method = RequestMethod.GET)
	public ResponseEntity<?> ZipArchive()
	{
		
		fileList = new ArrayList();
		Path currentWorkingDir = Paths.get("").toAbsolutePath();
		String path = currentWorkingDir.normalize().toString()+"/src/main/resources/student/home/provera";
    	generateFileList(new File(path));
    	
    	
    	Path currentWorkingDir1 = Paths.get("").toAbsolutePath();
		String path1 = currentWorkingDir.normalize().toString()+"/PJISP.zip";
    	
    	zipIt(path1);
    	
    	Path path2 = Paths.get(path1);
    	
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
	
	public void zipIt(String zipFile){
	     byte[] buffer = new byte[1024];
	     Path currentWorkingDir = Paths.get("").toAbsolutePath();
			String path = currentWorkingDir.normalize().toString()+"/src/main/resources/student/home/provera";
	    	
	     try{
	    	FileOutputStream fos = new FileOutputStream(zipFile);
	    	ZipOutputStream zos = new ZipOutputStream(fos);
	    	System.out.println("Output to Zip : " + zipFile);
	    	for(String file : fileList){
	    		System.out.println("File Added : " + file);
	    		ZipEntry ze= new ZipEntry(file);
	        	zos.putNextEntry(ze);
	        	FileInputStream in =
	                       new FileInputStream(path + File.separator + file);
	        	int len;
	        	while ((len = in.read(buffer)) > 0) {
	        		zos.write(buffer, 0, len);
	        	}
	        	in.close();
	    	}
	    	zos.closeEntry();
	    	//remember close it
	    	zos.close();
	    	System.out.println("Done");
	    }catch(IOException ex){
	       ex.printStackTrace();
	    }
	   }
	    /**
	     * Traverse a directory and get all files,
	     * and add the file into fileList
	     * @param node file or directory
	     */
	    public void generateFileList(File node){
	    	//add file only
		if(node.isFile()){
			fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList(new File(node, filename));
			}
		}
	    }
	    /**
	     * Format the file path for zip
	     * @param file file path
	     * @return Formatted file path
	     */
	    private String generateZipEntry(String file){
	    	Path currentWorkingDir = Paths.get("").toAbsolutePath();
			String path = currentWorkingDir.normalize().toString()+"/src/main/resources/student/home/provera";
	    
	    	return file.substring(path.length()+1, file.length());
	    }
	
	

	
}

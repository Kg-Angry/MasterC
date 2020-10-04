import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {timer} from 'rxjs';
import {saveAs}  from 'file-saver';

@Injectable({
  providedIn: 'root'
})
export class FinishService {

  constructor(private http: HttpClient) { }
  saveAs:any;
  counter = 0;
  download()
  {
    return this.http.get('api/multipartFileWorksHandler/download', {responseType: 'blob'})
    .subscribe(data =>
      {
        var newBlob = new Blob([data], { type: "application/zip" });
        const downloadURL = URL.createObjectURL(newBlob);
        window.open(downloadURL);
      });
  }

  convert(uploadPDF)
  {
      let fd = new FormData();
      fd.append('file', uploadPDF, uploadPDF.name);
      return this.http.post('api/multipartFileHandler/parseUploadedExcel', fd, {responseType: 'blob'}).
      subscribe(data => {

          var newBlob = new Blob([data], { type: "application/pdf" });
          const downloadURL = URL.createObjectURL(newBlob);
          localStorage.setItem(this.counter.toString(), JSON.stringify(downloadURL));
          // saveAs(newBlob,"proba.pdf");
          this.counter++;
          window.open(downloadURL);

        });
  }
}

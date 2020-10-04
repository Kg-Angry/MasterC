import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import {timer} from 'rxjs';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient,private router: Router) { }

  uploadFiles(selectedTest, uploadWorks, uploadCriteria)
  {
    if(uploadWorks !== null && uploadCriteria !== null)
    {
      let fd = new FormData();
      fd.append('file', uploadWorks, uploadWorks.name);

      let fd1 = new FormData();
      fd1.append('file', uploadCriteria, uploadCriteria.name);

      return this.http.post('api/multipartFileWorksHandler/parseUploadedWorks', fd).
      subscribe(data => {
        return this.http.post('api/multipartFileHandler/parseUploadedCriteria', fd1).
      subscribe(data => {
        Swal.fire({
          position: 'top-end',
          imageUrl: 'assets/image/spinner.gif',
          title: 'Proccessing data',
          showConfirmButton: false,
          timer: 3500
        });
        timer(2500).subscribe(t => this.router.navigateByUrl('/finish'))});
      });
    }else
    {
      Swal.fire({
        position: 'top-end',
        icon: 'error',
        title: 'Potrebno je uneti i kriterijum i radove',
        showConfirmButton: false,
        timer: 3500
      });
    }
  }

}

import { Injectable, ErrorHandler } from '@angular/core';
import Swal from 'sweetalert2';
import { HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class IntercepterService implements ErrorHandler {

  constructor() { }

  handleError(error: any) {
    if (error instanceof HttpErrorResponse) {
      if (error.status === 400) {
        Swal.fire({
          position: 'top-end',
          icon: 'error',
          title: 'Problem with registration',
          showConfirmButton: false,
          timer: 2500
        });
      } else if (error.status === 418) {
        Swal.fire({
          position: 'top-end',
          icon: 'error',
          title: 'User account not activated',
          showConfirmButton: false,
          timer: 2500
        });
      } else if(error.status === 404)
      {
        Swal.fire({
          position: 'top-end',
          icon: 'error',
          title: 'User not found',
          showConfirmButton: false,
          timer: 2500
        });
      }else if(error.status === 500)
      {
        Swal.fire({
          position: 'top-end',
          icon: 'error',
          title: 'Problem with server',
          showConfirmButton: false,
          timer: 2500
        });
      }
    }
  }
}

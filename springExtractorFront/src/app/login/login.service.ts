import { User } from './../Class/user';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import Swal from 'sweetalert2';
import { timer } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  email: String;
  lozinka: String;

  constructor(private http: HttpClient,private router: Router) { }

  logovanje(target)
  {
    this.email = target.querySelector('input[name=\'email\']').value;
    this.lozinka = target.querySelector('input[name=\'pass\']').value;

    return this.http.post('api/user/login', {email: this.email, password: this.lozinka})
    .subscribe(data => { Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: 'Uspesno ste se logovali',
      showConfirmButton: false,
      timer: 2500
    });

      timer(2500).subscribe(t => this.router.navigateByUrl('/home'));
      localStorage.setItem('korisnik', JSON.stringify(data));
    });


  }

  forgotPassword(target)
  {
    this.email = target.querySelector('input[name=\'emailForget\']').value;
    if(this.email !== null)
    {
      return this.http.get('api/user/forgotPassword/' + this.email).subscribe();
    }else
    {
      Swal.fire({
        position: 'top-end',
        icon: 'error',
        title: 'Morate uneti email',
        showConfirmButton: false,
        timer: 2500
      });
    }
  }
}

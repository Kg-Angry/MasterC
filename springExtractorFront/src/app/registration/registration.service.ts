import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import Swal from 'sweetalert2';
import { timer } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  name: String;
  surname: String;
  email: String;
  lozinka: String;

  constructor(private http: HttpClient,private router: Router) { }

  Registracija(target)
  {
    this.name = target.querySelector('input[name=\'name\']').value;
    this.surname = target.querySelector('input[name=\'surname\']').value;
    this.email = target.querySelector('input[name=\'email\']').value;
    this.lozinka = target.querySelector('input[name=\'pass\']').value;


    return this.http.post('api/user/registration', {name: this.name, surname: this.surname, email: this.email, password: this.lozinka})
    .subscribe(data => { Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: 'Uspesno ste se registrovali',
      showConfirmButton: false,
      timer: 2500
    });
      timer(2500).subscribe(t => this.router.navigateByUrl('/login'));
    });
  }
}

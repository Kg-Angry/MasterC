import { RegistrationService } from './registration.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private registracijaService: RegistrationService) { }

  ngOnInit(): void {
  }

  RegistracijaKorisnika($event) {
    event.preventDefault();
    const target = event.target;
    this.registracijaService.Registracija(target);
  }

}

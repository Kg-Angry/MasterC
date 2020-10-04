import { LoginService } from './login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }

  login($event)
  {
    event.preventDefault();
    const target = event.target;
    this.loginService.logovanje(target);
  }

  forgotPass($event)
  {
    event.preventDefault();
    const target = event.target;
    this.loginService.forgotPassword(target);
  }
}

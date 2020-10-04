import { Component } from '@angular/core';
import Swal from 'sweetalert2';
import { timer } from 'rxjs';
import {Event, Router, NavigationStart, NavigationEnd} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'springExtractor';

  korisnik = JSON.parse(localStorage.getItem('korisnik'));
  loadingIndicator = true;


  constructor(private _router: Router)
  {
    this._router.events.subscribe((routerEvent: Event) => {

      if(routerEvent instanceof NavigationStart)
      {
        this.loadingIndicator=true;
      }

      if(routerEvent instanceof NavigationEnd)
      {
        this.loadingIndicator=false;
      }
    })
  }


  LogOut()
  {
    localStorage.removeItem('korisnik');
    Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: 'Uspesno ste se izlogovali',
      showConfirmButton: false,
      timer: 2500
    });
    timer(2500).subscribe(t => location.href = '/firstPage');
  }
}

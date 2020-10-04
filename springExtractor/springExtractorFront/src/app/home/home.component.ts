import { HomeService } from './home.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  selectedTest: String = '';
  uploadWorks: File = null;
  uploadCriteria: File = null;
  tests: string[] = ['T12', 'T34', 'SOV', 'Popravni'];

  constructor(private homeService: HomeService) { }

  ngOnInit(): void {
  }

  UploadFiles($event)
  {

      this.homeService.uploadFiles(this.selectedTest, this.uploadWorks, this.uploadCriteria);

  }

  SelectFileWorks(event)
  {
    this.uploadWorks = event.target.files[0];
  }

  SelectFileCriteria(event)
  {
    this.uploadCriteria = event.target.files[0];
  }

}



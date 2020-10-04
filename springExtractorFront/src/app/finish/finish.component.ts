import { FinishService } from './finish.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-finish',
  templateUrl: './finish.component.html',
  styleUrls: ['./finish.component.css']
})
export class FinishComponent implements OnInit {

  uploadPDF: File = null;

  constructor(private finishService: FinishService) { }

  ngOnInit(): void {
  }

  download()
  {
    this.finishService.download();
  }

  SelectPDF(event)
  {
    this.uploadPDF = event.target.files[0];
  }

  uploadPDFF($event)
  {
    this.finishService.convert(this.uploadPDF);
  }

}

import { GeneratePDF } from './../Class/generate-pdf';
import { StudentService } from './student.service';
import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-student-home',
  templateUrl: './student-home.component.html',
  styleUrls: ['./student-home.component.css']
})
export class StudentHomeComponent implements OnInit {

  counter = 0;
  pdfs: GeneratePDF[]=[];
  pdf:GeneratePDF;
  constructor(private studentService: StudentService, private domSerial: DomSanitizer) { }

  ngOnInit(): void {

    while(JSON.parse(localStorage.getItem(this.counter.toString())) !== null )
    {
      this.pdf = new GeneratePDF();
      this.pdf.name = "Results " + this.counter;
      this.pdf.urlPath = JSON.parse(localStorage.getItem(this.counter.toString()));
      this.pdfs.push(this.pdf);
      this.counter++;
    }

  }

  preuzimanje(pdf)
  {
    this.studentService.preuzmi(pdf);
  }


}

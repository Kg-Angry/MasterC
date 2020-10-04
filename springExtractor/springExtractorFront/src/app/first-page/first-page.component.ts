import { StudentService } from './../student-home/student.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-first-page',
  templateUrl: './first-page.component.html',
  styleUrls: ['./first-page.component.css']
})
export class FirstPageComponent implements OnInit {

  role: string = '';

  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {

  }
  onItemChange(value)
  {
    if(value === 'profesor')
    {
      this.router.navigateByUrl('/login');

    }else
    {
      this.router.navigateByUrl('/student');
    }
  }
}

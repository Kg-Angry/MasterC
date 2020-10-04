import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import pdfMake from 'pdfmake/build/pdfmake';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  safeUrl: SafeUrl;
  constructor(private http: HttpClient,private domSerial: DomSanitizer) { }

  preuzmi(u:any)
  {
    window.open(u);
  }
}

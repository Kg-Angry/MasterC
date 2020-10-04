import { IntercepterService } from './intercepter.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import {FormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatDialogModule} from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input';
import {MatTableModule} from '@angular/material/table';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { FinishComponent } from './finish/finish.component';
import { FirstPageComponent } from './first-page/first-page.component';
import {MatSelectModule} from '@angular/material/select';
import { StudentHomeComponent } from './student-home/student-home.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomeComponent,
    FinishComponent,
    FirstPageComponent,
    StudentHomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule, MatCardModule, MatDialogModule, MatInputModule, MatTableModule,
    AppRoutingModule,
    MatSelectModule,
    HttpClientModule
  ],
  providers: [{provide : ErrorHandler,
    useClass: IntercepterService
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }

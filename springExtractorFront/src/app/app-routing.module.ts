import { StudentHomeComponent } from './student-home/student-home.component';
import { FirstPageComponent } from './first-page/first-page.component';
import { FinishComponent } from './finish/finish.component';
import { HomeComponent } from './home/home.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: '', redirectTo:'firstPage', pathMatch:'full'},
  {path: 'firstPage', component: FirstPageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'home', component: HomeComponent},
  {path: 'finish', component: FinishComponent},
  {path: 'student', component: StudentHomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

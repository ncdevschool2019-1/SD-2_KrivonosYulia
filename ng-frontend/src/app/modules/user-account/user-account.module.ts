import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {LoginComponent} from './components/login/login.component';
import {AuthService} from '../../services/auth.service';
import {FormDialogModule} from '../form-dialog/form-dialog.module';
import { RegistrationComponent } from './components/registration/registration.component';

@NgModule({
  declarations: [
    LoginComponent,
    RegistrationComponent],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormDialogModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [AuthService],
  exports: [LoginComponent, RegistrationComponent]
})
export class UserAccountModule {}

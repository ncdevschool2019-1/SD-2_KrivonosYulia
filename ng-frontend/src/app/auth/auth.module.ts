import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import {AuthComponent} from './auth.component';
import {AuthRoutingModule} from './auth-routing.module';
import { ProjelementComponent } from './projelement/projelement.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [LoginComponent,
    RegistrationComponent,
    AuthComponent,
    ProjelementComponent],
  imports: [
    CommonModule,
    AuthRoutingModule,
    FormsModule
  ]
})
export class AuthModule {}

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormDialogComponent} from "./modules/form-dialog/form-dialog.component";
import {LoginComponent} from "./modules/form-dialog/login/login.component";
import {RegistrationComponent} from "./modules/form-dialog/registration/registration.component";
import {NavBarComponent} from "./modules/layout/components/nav-bar/nav-bar.component";
import {LeftPanelComponent} from "./modules/layout/components/left-panel/left-panel.component";
import {GradientButtonComponent} from "./modules/layout/components/gradient-button/gradient-button.component";
import {UserAccountComponent} from "./modules/user-account/component/user-account/user-account.component";
import {TaskCreatorComponent} from "./modules/form-dialog/task-creator/task-creator.component";
import {NotFoundPageComponent} from "./modules/layout/components/not-found-page/not-found-page.component";
import {TaskTableComponent} from "./modules/task-table/task-table.component";
import {UserChangeAccountComponent} from "./modules/user-account/component/user-change-account/user-change-account.component";

import {ProjectcreatorComponent} from "./modules/form-dialog/projectcreator/projectcreator.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {FormDialogModule} from "./modules/form-dialog/form-dialog.module";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    FormDialogComponent,
    LoginComponent,
    RegistrationComponent,
    NavBarComponent,
    LeftPanelComponent,
    GradientButtonComponent,
    ProjectcreatorComponent,
    TaskCreatorComponent,
    NotFoundPageComponent,
    UserAccountComponent,
    UserChangeAccountComponent,
    TaskTableComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    FormDialogModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

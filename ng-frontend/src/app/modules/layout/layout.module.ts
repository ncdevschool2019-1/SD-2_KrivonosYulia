import { NgModule } from "@angular/core";
import {UserAccountModule} from '../user-account/user-account.module';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {HomeComponent} from './components/home/home.component';
import { ErrorPageComponent } from './components/error-page/error-page.component';
import {FormDialogModule} from "../form-dialog/form-dialog.module";
import {TasksModule} from "../tasks/tasks.module";
import {ProjectsModule} from "../projects/projects.module";

@NgModule({
  declarations: [
    HomeComponent,
    ErrorPageComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,

    FormDialogModule,
    TasksModule,
    ProjectsModule,
    HttpClientModule,
    UserAccountModule

  ],
  providers: [],
  exports: [HomeComponent,
    ErrorPageComponent]
})
export class LayoutModule {}

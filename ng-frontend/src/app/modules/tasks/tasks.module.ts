
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import { TasksComponent} from './component/table/tasks.component';
import { NewTaskComponent } from './component/new-task/new-task.component';
import {FormDialogModule} from '../form-dialog/form-dialog.module';
import {TypeaheadModule} from "ngx-bootstrap";
import {NgbModule, NgbRadio, NgbRadioGroup} from "@ng-bootstrap/ng-bootstrap";
import { TaskComponent } from './component/task/task.component';
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {DecimalPipe} from "@angular/common";



@NgModule({
  declarations: [
    TasksComponent,
    NewTaskComponent,
    TaskComponent
  ],
  imports: [

    NgbModule,
    BrowserModule,
    ReactiveFormsModule,
    RouterModule,

    // TypeaheadModule,
    Ng4LoadingSpinnerModule.forRoot(),
    FormsModule,
    HttpClientModule,
    FormDialogModule,
  ],
  providers: [DecimalPipe],
  exports: [
    TasksComponent,
    TaskComponent,
    NewTaskComponent]
})
export class TasksModule {}

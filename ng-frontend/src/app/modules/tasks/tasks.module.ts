
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {NgbdSortableHeader, TasksComponent} from './component/table/tasks.component';
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
    NgbdSortableHeader,
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
    NgbdSortableHeader,
    TaskComponent,
    NewTaskComponent]
})
export class TasksModule {}


import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {TasksComponent} from './component/table/tasks.component';
import { NewTaskComponent } from './component/new-task/new-task.component';
import {FormDialogModule} from '../form-dialog/form-dialog.module';

@NgModule({
  declarations: [
    TasksComponent,
    NewTaskComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    FormDialogModule,
  ],
  providers: [],
  exports: [
    TasksComponent,
    NewTaskComponent]
})
export class TasksModule {}

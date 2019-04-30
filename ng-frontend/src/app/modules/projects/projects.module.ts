import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import { NgModule} from '@angular/core';


import {FormDialogModule} from '../form-dialog/form-dialog.module';
import {ProjectService} from '../../services/project.service';
import { NewProjectComponent } from './components/new-project/new-project.component';
import { ProjectsCardComponent } from './components/projects-card/projects-card.component';
import { ProjectComponent } from './components/project/project.component';

@NgModule({
  declarations: [
    NewProjectComponent,
    ProjectsCardComponent,
    ProjectComponent],
  imports: [
    BrowserModule,

    ReactiveFormsModule,

    FormDialogModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [ProjectService],
  exports: [NewProjectComponent]
})
export class ProjectsModule {}

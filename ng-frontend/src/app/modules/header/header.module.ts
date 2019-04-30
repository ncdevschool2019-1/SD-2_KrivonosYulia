import { NgModule } from "@angular/core";
import {HeaderComponent} from "./components/header.component";
import {UserAccountModule} from '../user-account/user-account.module';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {FormDialogModule} from '../form-dialog/form-dialog.module';
import {TasksModule} from '../tasks/tasks.module';
import {ProjectsModule} from '../projects/projects.module';
import {ModalService} from "../../services/modal.service";


@NgModule({
  declarations: [
    HeaderComponent
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
  providers: [ModalService],
  exports: [HeaderComponent]
})
export class HeaderModule {}

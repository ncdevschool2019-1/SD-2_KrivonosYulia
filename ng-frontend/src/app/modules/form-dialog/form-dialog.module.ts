
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormDialogComponent} from './component/form-dialog.component';
import {ModalService} from "../../services/modal.service";

@NgModule({
  declarations: [
    FormDialogComponent],
  imports: [
    BrowserModule,
    RouterModule,
    ReactiveFormsModule,

    FormsModule,
    HttpClientModule,
  ],
  providers: [ModalService],
  exports: [FormDialogComponent]
})
export class FormDialogModule {}


import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormDialogComponent} from './component/form-dialog.component';

@NgModule({
  declarations: [
    FormDialogComponent],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  exports: [FormDialogComponent]
})
export class FormDialogModule {}

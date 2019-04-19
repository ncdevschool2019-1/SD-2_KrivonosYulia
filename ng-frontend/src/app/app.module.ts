import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LayoutModule} from "./modules/layout/layout.module";
import {HeaderModule} from "./modules/header/header.module";
import {TasksModule} from './modules/tasks/tasks.module';
import {ModalModule} from "ngx-bootstrap";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    TasksModule,
    LayoutModule,
    ReactiveFormsModule,
    AppRoutingModule,
    ModalModule.forRoot(),
    HeaderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

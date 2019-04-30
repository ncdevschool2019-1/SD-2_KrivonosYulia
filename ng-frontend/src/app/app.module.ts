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

import {LeftPanelModule} from "./modules/left-panel/left-panel.module";

import {SearchElementModule} from "./modules/search-element/search-element.module";
import { FooterComponent } from './modules/footer/footer.component';
import { TypeaheadModule } from 'ngx-bootstrap/typeahead';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {UserAccountModule} from "./modules/user-account/user-account.module";

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,


  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
UserAccountModule,
    SearchElementModule,
    TasksModule,
    HeaderModule,
    LeftPanelModule,
    LayoutModule,
    LayoutModule,
    ReactiveFormsModule,
    AppRoutingModule,
    ModalModule.forRoot(),
    TypeaheadModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./modules/user-account/components/login/login.component";
import {HomeComponent} from "./modules/layout/components/home/home.component";

const routes: Routes = [
  // {path: '/', component: HomeComponent},
  // {path: '/login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

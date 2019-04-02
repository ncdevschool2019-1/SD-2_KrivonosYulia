import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./modules/form-dialog/login/login.component";
import {RegistrationComponent} from "./modules/form-dialog/registration/registration.component";
import {ProjectcreatorComponent} from "./modules/form-dialog/projectcreator/projectcreator.component";
import {TaskCreatorComponent} from "./modules/form-dialog/task-creator/task-creator.component";
import {TaskComponent} from "./modules/form-dialog/task/task.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'new-project', component: ProjectcreatorComponent},
  {path: 'new-task', component: TaskCreatorComponent},
  {path: 'task/id', component: TaskComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

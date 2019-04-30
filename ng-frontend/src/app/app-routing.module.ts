import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {ProjectsCardComponent} from "./modules/projects/components/projects-card/projects-card.component";
import {TasksComponent} from "./modules/tasks/component/table/tasks.component";
import {LoginComponent} from "./modules/user-account/components/login/login.component";

const routes: Routes = [
  // { path: '', redirectTo: '/projects', pathMatch: 'full' },
  {path: 'projects', component: ProjectsCardComponent},
  {path: 'tasks/project/:projectId', component: TasksComponent},
  {path: 'login', component: LoginComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

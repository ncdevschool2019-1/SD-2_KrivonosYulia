import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Project} from '../modules/projects/model/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  constructor(private http: HttpClient) { }

  saveProject(project: Project): Observable<Project>{
    return this.http.post<Project>('http://localhost:8088/api/projects',Project)
  }
  deleteProject(projectId: string): Observable<void>{
    return this.http.delete<void>('http://localhost:8088/api/projects'+ projectId)
  }
  editProject(project: Project): Observable<Project>{
    return this.http.post<Project>('http://localhost:8088api/projects',project)
  }

  getAllProject(): Observable<Project[]>{
    return this.http.get<Project[]>('http://localhost:8088/api/projects');
  }

  getProjectById(projectId: string): Observable<Project>{
    return this.http.get<Project>('http://localhost:8088/api/projects' + projectId);
  }
}

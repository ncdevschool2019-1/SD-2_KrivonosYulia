import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Project} from '../model/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private http: HttpClient) { }

  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>('/api/ba/');
  }

  saveProject(project: Project): Observable<Project>{
    return this.http.post<Project>('/api/ba/',project);
  }
  deleteProject(projectId: string): Observable<void>{
    return this.http.delete<void>('/api/ba/'+projectId);
  }
  getProjectById(id: string): Observable<Project> {
    return this.http.get<Project>('/api/ba/' + id);
  }
}

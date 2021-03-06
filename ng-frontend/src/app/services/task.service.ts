import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Task} from '../modules/tasks/model/task';
@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http: HttpClient) { }

  saveTask(task: Task): Observable<Task>{
    return this.http.post<Task>('http://localhost:8008/api/tasks/',task)
  }
  deleteTask(taskId: string): Observable<void>{
    return this.http.delete<void>('http://localhost:8008/api/tasks/'+ taskId)
  }
  editTask(task: Task): Observable<Task>{
    return this.http.post<Task>('http://localhost:8008/api/tasks/',task)
  }

  getAll(): Observable<Task[]>{
    return this.http.get<Task[]>('http://localhost:8008/api/tasks/');
  }

  getTasksByProject(projectId : number): Observable<Task[]>{
    return this.http.get<Task[]>('http://localhost:8008/api/tasks/project/'+projectId);
  }

  getTaskById(taskId: string): Observable<Task>{
    return this.http.get<Task>('http://localhost:8008/api/tasks/' + taskId);
  }

  saveAttachments(file: File, id: number): Observable<Task>{
    const formData = new FormData();
    formData.append('files', file, file.name);
    return this.http.put<Task>('http://localhost:8008/api/tasks/file/' + id, formData);
  }
}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';

import {Task} from '../model/task';
import {Tasks} from '../model/tasks';

@Injectable({
  providedIn: 'root'
})
export class TasksService {

  tasks: Task[];

  constructor(private http: HttpClient) { }

  getTasksExample(): Observable<Task[]> {
    return of(Tasks);
  }

  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>('/api/ba/');

  }

  saveTask(task: Task): Observable<Task>{
    return this.http.post<Task>('/api/ba/',task);
  }
  deleteTask(taskId: string): Observable<void>{
    return this.http.delete<void>('/api/ba/'+taskId);
  }
  getTaskById(id: string): Observable<Task> {
    return this.http.get<Task>('/api/ba/' + id);
  }
}

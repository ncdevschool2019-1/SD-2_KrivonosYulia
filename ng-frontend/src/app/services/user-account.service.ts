import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../model/user';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserAccountService {

  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/ba/');
  }

  saveUser(user: User): Observable<User>{
    return this.http.post<User>('/api/ba/',user);
  }
  deleteUser(userId: string): Observable<void>{
    return this.http.delete<void>('/api/ba/'+userId);
  }
  getUserById(id: string): Observable<User> {
    return this.http.get<User>('/api/ba/' + id);
  }

}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from "../modules/user-account/model/user";


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getAll():Observable<User[]>{
    return this.http.get<User[]>('http://localhost:8008/api/users/');
  }

  getById(id: string): Observable<User>{
    return this.http.get<User>(`http://localhost:8008/api/users/` + id);
  }

  deleteUser(id: string): Observable<void>{
    return this.http.delete<void >('http://localhost:8008/api/users'+ id);
  }

  saveUser(user: User): Observable<User>{
    return this.http.post<User>('http://localhost:8008/api/users/', user);
  }
}

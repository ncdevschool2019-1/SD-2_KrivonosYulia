import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../modules/user-account/model/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  validateLogin(user:User): Observable<void>{
    return this.http.post<void>('api/user/login', user);
  }
}

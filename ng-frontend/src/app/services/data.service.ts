import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Project} from "../modules/projects/model/project";
import {Observable} from "rxjs";
import {Priority} from "../modules/tasks/model/priority";
import {Role} from "../modules/tasks/model/role";
import {Status} from "../modules/tasks/model/status";

@Injectable({
  providedIn: 'root'
})
export class DataService {
  constructor(private http: HttpClient) { }

  getPriorities(): Observable<Priority[]>{
    return this.http.get<Priority[]>('http://localhost:8008/api/priorities');
  }
  getStatuses(): Observable<Status[]>{
    return this.http.get<Status[]>('http://localhost:8008/api/status');
  }
  getRoles(): Observable<Role[]>{
      return this.http.get<Role[]>('http://localhost:8008/api/roles');
  }
}

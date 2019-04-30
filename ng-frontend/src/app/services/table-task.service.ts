import {Injectable, PipeTransform} from '@angular/core';
import {BehaviorSubject, Observable, of, Subject} from 'rxjs';
import {Task} from '../modules/tasks/model/task';
import {DecimalPipe} from "@angular/common";
import {debounceTime, delay, switchMap, tap} from "rxjs/operators";
// import {SortDirection} from './sortable.directive';

function compare(v1, v2) {
  return v1 < v2 ? -1 : v1 > v2 ? 1 : 0;
}

interface State {
  page: number;
  pageSize: number;
  searchTerm: string;
  sortColumn: string;
  sortDirection: string;
}

interface SearchResult {
  tasks: Task[];
  total: number;
}


function sort(tasks: Task[], column: string, direction: string): Task[] {
  if (direction === '') {
    return tasks;
  } else {
    return [...tasks].sort((a, b) => {
      const res = compare(a[column], b[column]);
      return direction === 'asc' ? res : -res;
    });
  }
}

function matches(task: Task, term: string, pipe: PipeTransform) {
  return task.projectCode.projectCode.toUpperCase().includes(term)
    || pipe.transform(task.createdDate).includes(term)
    || pipe.transform(task.updatedDate).includes(term)
    || pipe.transform(task.dueDate).includes(term)
    || pipe.transform(task.estimation).includes(term)
    || pipe.transform(task.assignedUser).includes(term)
    || pipe.transform(task.reporter).includes(term)
    || pipe.transform(task.priority).includes(term)
    || pipe.transform(task.taskCode).includes(term)
    || pipe.transform(task.status).includes(term);
}

@Injectable({
  providedIn: 'root'
})
export class TableTaskService {
  private _loading$ = new BehaviorSubject<boolean>(true);
  private _search$ = new Subject<void>();
  private _tasks$ = new BehaviorSubject<Task[]>([]);
  private _total$ = new BehaviorSubject<number>(0);

  private _state: State = {
    page: 1,
    pageSize: 5,
    searchTerm: '',
    sortColumn: '',
    sortDirection: ''
  };


  constructor(private pipe: DecimalPipe) {
  }

  public search(task: Task[]){
    this._search$.pipe(
      tap(() => this._loading$.next(true)),
      debounceTime(200),
      switchMap(() => this._search(task)),
      delay(200),
      tap(() => this._loading$.next(false))
    ).subscribe(result => {
      this._tasks$.next(result.tasks);
      this._total$.next(result.total);
    });

    this._search$.next();
  }

  get tasks$() { return this._tasks$.asObservable(); }
  get total$() { return this._total$.asObservable(); }
  get loading$() { return this._loading$.asObservable(); }
  get page() { return this._state.page; }
  get pageSize() { return this._state.pageSize; }
  get searchTerm() { return this._state.searchTerm; }

  set page(page: number) { this._set({page}); }
  set pageSize(pageSize: number) { this._set({pageSize}); }
  set searchTerm(searchTerm: string) { this._set({searchTerm}); }
  set sortColumn(sortColumn: string) { this._set({sortColumn}); }
  // set sortDirection(sortDirection: SortDirection) { this._set({sortDirection});}

  private _set(patch: Partial<State>) {
    Object.assign(this._state, patch);
    this._search$.next();
  }

  private _search(taskForSort: Task[]): Observable<SearchResult> {
    const {sortColumn, sortDirection, pageSize, page, searchTerm} = this._state;

    // 1. sort
    let tasks = sort(taskForSort, sortColumn, sortDirection);

    // 2. filter
    tasks = tasks.filter(task => matches(task, searchTerm, this.pipe));
    const total = tasks.length;

    // 3. paginate
    tasks = tasks.slice((page - 1) * pageSize, (page - 1) * pageSize + pageSize);
    return of({tasks, total});
  }
}

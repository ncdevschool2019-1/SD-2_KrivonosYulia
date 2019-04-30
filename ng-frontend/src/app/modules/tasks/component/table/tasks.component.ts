import {
  Component,
  Directive,
  EventEmitter,
  Input,
  OnInit,
  Output, PipeTransform,
  QueryList,
  TemplateRef,
  ViewChildren
} from '@angular/core';
import {TaskService} from '../../../../services/task.service';
import {Task} from '../../model/task';
import {Observable, Subscription} from 'rxjs';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {FormControl} from "@angular/forms";
import {DecimalPipe} from "@angular/common";
import {map, startWith} from "rxjs/operators";
export type SortDirection = 'asc' | 'desc' | '';
const rotate: {[key: string]: SortDirection} = { 'asc': 'desc', 'desc': '', '': 'asc' };
export const compare = (v1, v2) => v1 < v2 ? -1 : v1 > v2 ? 1 : 0;

export interface SortEvent {
  column: string;
  direction: SortDirection;
}

@Directive({
  selector: 'th[sortable]',
  host: {
    '[class.asc]': 'direction === "asc"',
    '[class.desc]': 'direction === "desc"',
    '(click)': 'rotate()'
  }
})
export class NgbdSortableHeader {

  @Input() sortable: string;
  @Input() direction: SortDirection = '';
  @Output() sort = new EventEmitter<SortEvent>();

  rotate() {
    this.direction = rotate[this.direction];
    this.sort.emit({column: this.sortable, direction: this.direction});
  }
}



@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  tasks: Task[];
  // tasksS: Observable<Task[]>;

  @ViewChildren(NgbdSortableHeader) headers: QueryList<NgbdSortableHeader>;


  // filter = new FormControl('');

  page: number = 1;
  pageSize:number = 10;

  public editMode = false;
  public editableTask: Task = new Task();



  private subscriptions: Subscription[] = [];


  public modalRef: BsModalRef;
  //we need a variable to keep a reference of our modal. This is going to be used to close the modal.

  constructor(
    // pipe: DecimalPipe,

              private modalService: BsModalService ,
              private loadingService: Ng4LoadingSpinnerService,
              private taskService: TaskService) {
    // this.tasksS = this.filter.valueChanges.pipe(
    // startWith(''),
    // map(text => this.search(text, pipe))
  // );
  }

  ngOnInit() {
    this.taskService.getAll().subscribe(
      data => this.tasks = data
    );
  }
  private onSort({column, direction}: SortEvent){
    // resetting other headers

    this.headers.forEach(header => {
      if (header.sortable !== column) {
        header.direction = '';
      }
    });

    // sorting countries
    if (direction === '') {
      this.loadTasks();
    } else {

      this.tasks = this.tasks.sort((a, b) => {
        const res = compare(a[column], b[column]);
        return direction === 'asc' ? res : -res;
      });
    }

}
  private newDate(seconds: number){
    return new Date(seconds);
  }


  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, task: Task): void {

    if (task) {
      this.editMode = true;
      this.editableTask = Task.cloneTask(task);
    } else {
      this.refreshTask();
      this.editMode = false;
    }
    this.modalRef = this.modalService.show(template);
  }
  public _addBillingAccount(): void {
    this.loadingService.show();
    this.subscriptions.push(this.taskService.saveTask(this.editableTask).subscribe(() => {
      this._updateBillingAccounts();
      this.refreshTask();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateBillingAccounts(): void {
    this.loadTasks();
  }

  public _deleteBillingAccount(taskId: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.taskService.deleteTask(taskId).subscribe(() => {
      this._updateBillingAccounts();
    }));
  }

  private refreshTask(): void {
    this.editableTask = new Task();
  }


  private loadTasks(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.taskService.getAll()
      .subscribe(tsk => {
        this.tasks = tsk as Task[];

      }));
    this.loadingService.hide();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  //  search( text: string, pipe: PipeTransform): Task[] {
  //   return this.tasks.filter(tsk => {
  //     const term = text.toUpperCase();
  //     return pipe.transform(tsk.projectCode.projectCode).includes(term);
  //
  //   });
  // }

}

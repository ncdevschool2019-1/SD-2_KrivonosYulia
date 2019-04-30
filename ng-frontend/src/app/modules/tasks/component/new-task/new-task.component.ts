import {Component, OnChanges, OnDestroy, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {FormControl, FormGroup, FormGroupName, Validators} from '@angular/forms';
import {Task} from '../../model/task';
import {TaskService} from '../../../../services/task.service';
import {Project} from "../../../projects/model/project";
import {ProjectService} from "../../../../services/project.service";
import {merge, Observable, Subject, Subscription} from "rxjs";
import {debounceTime, distinctUntilChanged, filter, map} from "rxjs/operators";
import {NgbDate, NgbTypeahead} from "@ng-bootstrap/ng-bootstrap";
import {Priority} from "../../model/priority";
import {Status} from "../../model/status";
import {DataService} from "../../../../services/data.service";
import {UserService} from "../../../../services/user.service";
import {User} from "../../../user-account/model/user";

@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {

  title: string  = "New task";
  model: User;
  displayMonths = 2;

  task : Task = new Task();
  fileList: FileList;
  prioties: Priority[];
  users: User[];
  status: Status[];
  projects: Project[];
  form: FormGroup;
  private subscriptions: Subscription[] = [];
  isDisabled = (date: NgbDate) =>
    date > this.date;

  today = new Date();
  date: NgbDate;

  @ViewChild('instance') instance: NgbTypeahead;
  focus$ = new Subject<string>();
  click$ = new Subject<string>();


  @ViewChild('instanceUser') instanceUser: NgbTypeahead;
  focusUser$ = new Subject<string>();
  clickUser$ = new Subject<string>();



  constructor(private taskService: TaskService,
              private dataService: DataService,
              private userService : UserService,
              private projectService : ProjectService) {


  }

  private getDataFromBD(){
    this.projectService.getAllProject().subscribe(
      data => this.projects = data as Project[]
    );

    this.dataService.getStatuses().subscribe(
      data => this.status = data as Status[]
    );

    this.dataService.getPriorities().subscribe(
      data => this.prioties = data as Priority[]
    );

    this.userService.getAll().subscribe(
      data => this.users = data as User[]
    );
  }


  ngOnInit() {

    this.getDataFromBD();
    this.date = new NgbDate( this.today.getFullYear(), this.today.getMonth(),this.today.getDay());
    this.form = new FormGroup({

        taskCode: new FormControl(null, Validators.required),
        projectCode: new FormControl(null,Validators.required ),
        priority: new FormControl(null,Validators.required,  ),
        dueDate: new FormControl(null ,Validators.required, ),
        assignedUser: new FormControl(null,Validators.required, ),
        description : new FormControl(null, Validators.required, )
      }
    );
  }

  searchProject = (text$: Observable<string>) =>{
    const debouncedText$ = text$.pipe(debounceTime(200), distinctUntilChanged());
    const clicksWithClosedPopup$ = this.click$.pipe(filter(() => !this.instance.isPopupOpen()));
    const inputFocus$ = this.focus$;

    return merge(debouncedText$, inputFocus$, clicksWithClosedPopup$).pipe(
      map(term => (term === '' ? this.projects
        : this.projects.filter(v => v.projectCode.toLowerCase().indexOf(term.toLowerCase()) > -1)).slice(0, 10))
    );
  };
  formatterProject = (x: Project) => x.projectCode;



  searchUser = (text$: Observable<string>) => {
    const debouncedText$ = text$.pipe(debounceTime(200),
      distinctUntilChanged());
    const clicksWithClosedPopup$ = this.click$.pipe(
      filter(() => !this.instance.isPopupOpen()));
    const inputFocus$ = this.focus$;

    return merge(debouncedText$, inputFocus$, clicksWithClosedPopup$).pipe(
      map(term => (term === '' ? this.users
        : this.users.filter(v => v.email.toLowerCase().indexOf(term.toLowerCase()) > -1)).slice(0, 10))
    );
  };
  formatterUser = (x: User) => x.email;

  // uploadImage(event) {
  //   this.loadingService.show();
  //   this.fileList = event.target.files;
  //   if (this.fileList && this.fileList.length > 0) {
  //
  //     this.subscriptions.push(this.userService.saveUsersImage(this.fileList[0], this.authorizedUser.id).subscribe(value => {
  //       this.authorizedUser = value;
  //       this.authService.setAuthUser(this.authorizedUser);
  //       this.toastr.success('Image was saved', 'Success');
  //     }, error => {
  //       this.toastr.error('Загрузить фото не удалось', 'Ошибка');
  //     }, () => this.loadingService.hide()));
  //   }
  // }


  onSubmit(){
    let due  = this.form.value["dueDate"];
    let task  :Task = this.form.value as Task;
    task.id =0 ;
    task.priority = this.form.value["priority"];
    task.projectCode = this.form.value["projectCode"];
    task.dueDate = new Date(due.year,due.month,due.day).getTime();
    task.assignedUser = this.form.value["assignedUser"];
    // task.status = this.
    task.createdDate = this.today.getTime();
    task.description = this.form.value["description"];
    task.taskCode = this.form.value["taskCode"];
    task.updatedDate = task.createdDate;
    task.reporter  = task.assignedUser;
    task.status = this.status[0];
    task.estimation = task.dueDate - task.createdDate;
    console.log(this.taskService.saveTask(task).subscribe());
    console.log(this.form.value);
    console.log(task);

  }



}

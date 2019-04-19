import {Component, OnInit, TemplateRef} from '@angular/core';
import {TaskService} from '../../../../services/task.service';
import {Task} from '../../model/task';
import {Subscription} from 'rxjs';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  tasks: Task[];

  public editMode = false;
  public editableTask: Task = new Task();
  private subscriptions: Subscription[] = [];
  public modalRef: BsModalRef; //we need a variable to keep a reference of our modal. This is going to be used to close the modal.

  constructor(
              private modalService: BsModalService ,

              private taskService: TaskService) { }

  ngOnInit() {
    this.taskService.getAll().subscribe(
      data => this.tasks = data
    );
    this.taskService.getAll().subscribe(dataTask  => console.log(dataTask));
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

    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }
  public _addBillingAccount(): void {
    // this.loadingService.show();
    this.subscriptions.push(this.taskService.saveTask(this.editableTask).subscribe(() => {
      this._updateBillingAccounts();
      this.refreshTask();
      this._closeModal();
      // this.loadingService.hide();

    }));
  }

  public _updateBillingAccounts(): void {
    this.loadTasks();
  }

  public _deleteBillingAccount(taskId: string): void {
    // this.loadingService.show();
    this.subscriptions.push(this.taskService.deleteTask(taskId).subscribe(() => {
      this._updateBillingAccounts();
    }));
  }

  private refreshTask(): void {
    this.editableTask = new Task();
  }


  private loadTasks(): void {

    // Get data from BillingAccountService
    this.subscriptions.push(this.taskService.getAll()
      .subscribe(tsk => {
        // Parse json response into local array
        this.tasks = tsk as Task[];
        // Check data in console
        // console.log(this.tasks$);
        // don't use console.log in angular :)

      }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}

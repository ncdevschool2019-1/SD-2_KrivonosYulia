import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Task} from '../../model/task';
import {TaskService} from '../../../../services/task.service';

@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {

  title: string  = "New task";

  task: Task;
  form: FormGroup;

  constructor(private taskSErvice: TaskService) { }



  ngOnInit() {
    this.form = new FormGroup({
        "taskCode": new FormControl(null, [Validators.required]),
    // "description": new FormControl(null, [Validators.required]),
    // "priority": new FormControl(null, [Validators.required]),
    // "projectCode": new FormControl(null, [Validators.required]),
    // "status": new FormControl(null, [Validators.required]),
    // "dueDate": new FormControl(null, [Validators.required]),
    // "estimation": new FormControl(null, [Validators.required]),
    // "createdDate": new FormControl(null, [Validators.required]),
    // "updatedDate": new FormControl(null, [Validators.required]),
    //  "reporter": new FormControl(null, [Validators.required]),
    // "assignedUser": new FormControl(null, [Validators.required])
      }
    );

  }
}

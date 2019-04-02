import { Component, OnInit } from '@angular/core';
import {TasksService} from '../../services/tasks.service';
import {Task} from '../../model/task';

@Component({
  selector: 'app-task-table',
  templateUrl: './task-table.component.html',
  styleUrls: ['./task-table.component.css']
})
export class TaskTableComponent implements OnInit {
  tasks$: Task[];
  constructor(private data: TasksService) { }

  ngOnInit() {
    this.data.getTasksExample().subscribe(
      data => this.tasks$ = data
    );
  }


}

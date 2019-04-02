import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-task-creator',
  templateUrl: './task-creator.component.html',
  styleUrls: ['./task-creator.component.css']
})
export class TaskCreatorComponent implements OnInit {

  formTask: FormGroup;
  constructor() { }

  ngOnInit() {
    this.formTask = new FormGroup({

    })
  }


}

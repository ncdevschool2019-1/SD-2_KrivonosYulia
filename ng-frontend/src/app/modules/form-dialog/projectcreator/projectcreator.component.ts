import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-projectcreator',
  templateUrl: './projectcreator.component.html',
  styleUrls: ['./projectcreator.component.css']
})
export class ProjectcreatorComponent implements OnInit {
formProject: FormGroup;
  constructor() { }

  ngOnInit() {
    this.formProject = new FormGroup({
      'projectCode': new FormControl({value: 'Nancy', disabled: true}, [Validators.required]),
      'summary': new FormControl(null)
    })
  }

  onSubmit(){

  }
}

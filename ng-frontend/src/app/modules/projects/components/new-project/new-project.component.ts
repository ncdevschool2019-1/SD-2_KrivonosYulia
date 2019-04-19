import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ProjectService} from '../../../../services/project.service';
import {Project} from "../../model/project";

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {
  title: string  = "New project";
  formProject: FormGroup;

  project: Project;
  submitted = false;


  constructor(private projectService: ProjectService) { }

  ngOnInit() {
    // this.formProject = new FormGroup({
    //   'projectCode': new FormControl({value: "Code", disabled: true}, [Validators.required]),
    //   'summary': new FormControl(null,[Validators.maxLength(255), Validators.required])
    // })
  }

  onSubmit(){
    this.submitted = true;
    if(this.formProject.invalid){
      return;
    }
    // this.projectService.saveProject().subscribe();

  }
}

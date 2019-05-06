import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, NgForm, Validators} from '@angular/forms';
import {ProjectService} from '../../../../services/project.service';
import {Project} from "../../model/project";
import {ModalService} from "../../../../services/modal.service";


@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {



  title: string  = "New project";
  formProject: FormGroup;

  submitted = false;

  constructor(private projectService: ProjectService,
              private ms: ModalService) {
  }


  ngOnInit() {
    this.formProject = new FormGroup({
      id: new FormControl( 0),
      projectCode: new FormControl("code", [Validators.required , Validators.maxLength(6)]),
      summary: new FormControl(null,[Validators.required ,Validators.maxLength(255)])
    })
  }

  onSubmit(){
    this.submitted = true;
    console.log(this.formProject);
    let project: Project = this.formProject.value;
    console.log(project);
    this.projectService.saveProject(project).subscribe();

  }
}

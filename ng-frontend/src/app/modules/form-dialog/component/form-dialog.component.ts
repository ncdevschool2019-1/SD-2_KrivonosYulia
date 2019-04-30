import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {ModalService} from "../../../services/modal.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-form-dialog',
  templateUrl: './form-dialog.component.html',
  styleUrls: ['./form-dialog.component.css']
})
export class FormDialogComponent implements OnInit {
  @Input('titleForm') titleForm :string  = "modal ";

  constructor(private modalService: NgbModal){}


  public closeModal(){
    this.modalService.dismissAll();
  }

  ngOnInit() {
  }

}

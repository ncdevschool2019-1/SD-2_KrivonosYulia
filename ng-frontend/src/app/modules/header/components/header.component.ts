import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {ModalService} from "../../../services/modal.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Input('titleForm') titleForm :string  = "modal ";
  constructor(private modalserv : NgbModal) { }

  public _openModal(template: TemplateRef<any>): void {
    this.modalserv.open(template,{ size: 'lg' } );
  }

  ngOnInit() {
  }



}

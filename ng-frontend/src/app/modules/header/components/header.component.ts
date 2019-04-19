import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private modalService: BsModalService) { }

  modalRef: BsModalRef;

  public _closeModal(click: any) {
    click==true?this.modalRef.hide(): undefined;
  }

  public _openModal(template: TemplateRef<any>): void {

    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }

  ngOnInit() {
  }

}

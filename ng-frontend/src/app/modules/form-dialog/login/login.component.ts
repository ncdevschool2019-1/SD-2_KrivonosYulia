import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {User} from '../../../model/user';
import {UserAccountService} from '../../../services/user-account.service';
import {AuthService} from '../../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
formLogin : FormGroup;


  public userAccount : User[];
  public  modalRef: BsModalRef;
  public user: User;


  constructor(private authService: AuthService,
              private modalService: BsModalService,
              ) { }


  ngOnInit() {
    this.formLogin = new FormGroup({
      'email': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators.required, Validators.minLength(6)])
    })
  }

  onSubmit(){

  }
  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, userAccount: User): void {

    if (userAccount) {

    }
  }

  private loadUserAccounts(): void {
    // this.loadingService.show();
    // Get data from BillingAccountService
    // this.subscriptions.push(this.billingAccountService.getBillingAccounts().subscribe(accounts => {
      // Parse json response into local array
      // this.billingAccounts = accounts as BillingAccount[];
      // Check data in console
    //
    //   this.loadingService.hide();
    // }));
  }
 ngOnDestroy(): void{

 }

 loginUser(){
 }

}

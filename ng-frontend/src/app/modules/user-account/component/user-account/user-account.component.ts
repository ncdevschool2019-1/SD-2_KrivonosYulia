import {Component, OnInit, TemplateRef} from '@angular/core';
import {User} from '../../../../model/user';
import {Subscription} from 'rxjs';
import {UserAccountService} from '../../../../services/user-account.service';


@Component({
  selector: 'app-user-account',
  templateUrl: './user-account.component.html'
})
export class UserAccountComponent implements OnInit {



  public users: User[];
  public editableUser: User = new User();
  private subscriptions: Subscription[] = [];

  constructor(private userService: UserAccountService,
              // private loadingService: Ng4LoadingSpinnerService,
              // private modalService: BsModalService
  )
  {
    //to show the modal, we also need the ngx-bootstrap service) { }
  }
  ngOnInit() {
  }
  public _openModal(template: TemplateRef<any>, userAccount: User): void {

    if (userAccount) {

      // this.editableBa = User.cloneUser(userAccount);
    }
    else{

    }
  }
}


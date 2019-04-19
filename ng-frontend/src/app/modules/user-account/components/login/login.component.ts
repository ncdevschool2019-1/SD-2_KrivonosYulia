import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../../../../services/auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import {User} from '../../model/user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  title: string  = "Log in";
  formLogin : FormGroup;
  public userAccount : User[];
  loading = false;
  submitted = false;
  returnUrl: string;
  public user: User;


  constructor(private route: ActivatedRoute,
              private router: Router,
              private authService: AuthService
  ) {}


  ngOnInit() {

    this.formLogin = new FormGroup({
      'email': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators.required, Validators.minLength(6)])
    });
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';

  }

  onSubmit() {
    this.submitted = true;

    if (this.formLogin.invalid) {
      return;
    }
    this.loading = true;
    // this.authService.validateLogin().subscribe();
    //
  }

}

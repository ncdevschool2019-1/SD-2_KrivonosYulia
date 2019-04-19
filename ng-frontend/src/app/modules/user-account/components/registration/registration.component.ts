import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {UserService} from '../../../../services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  title: string  = "Registration";
  constructor(private userService: UserService) { }

  form: FormGroup;

  ngOnInit() {
    this.form = new FormGroup({
      'email': new FormControl(null, [Validators.required, Validators.email]),
      'login': new FormControl(null, [Validators.required]),
      'role': new FormControl(null, [Validators.required]),
      'password': new FormControl(null, [Validators.required, Validators.minLength(6)])
    })
  }
}

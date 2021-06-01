import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User();
  msg = '';

  constructor(private registrationService: RegistrationService, private router: Router) { }

  ngOnInit(): void {
  }

    loginUser(){ 
      this.registrationService.loginUserFromRemote(this.user).subscribe(
        data =>{ 
          console.log("response recieced");
          this.router.navigate(['/home']);
        },
        error => this.msg="Bad credentials, please enter valid username and password"
      )
    }
}

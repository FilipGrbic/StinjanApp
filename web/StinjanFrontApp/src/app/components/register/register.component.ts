import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../../models/user';
import { RegistrationService } from '../../services/registration.service';
import { Router } from '@angular/router';
import { Role } from 'src/app/models/role';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user = new User();
  msg="";
  role = new Role(2, "User", "user");

  constructor(private registrationService: RegistrationService, private router: Router) { }

  ngOnInit(): void {
  }
  
  registerUser(){
    this.user.role = this.role;
    this.registrationService.registerUser(this.user).subscribe(
      data => {
        this.msg = "Registration successful";
        this.router.navigate(['/login']);
      },
      error => console.log(this.user)
    )
  }

}

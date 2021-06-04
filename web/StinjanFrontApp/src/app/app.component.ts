import { Component } from '@angular/core';
import { LoginComponent } from './components/login/login.component';
import { RegistrationService } from './services/registration.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [LoginComponent]
})
export class AppComponent {
  title = 'StinjanFrontApp';

  constructor(public loginComponent: LoginComponent, public registrationService: RegistrationService){}
}

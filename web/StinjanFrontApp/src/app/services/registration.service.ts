import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user'

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  private registerUrl = "http://localhost:4063/user/register"
  private loginUrl = "http://localhost:4063/user/login"

  constructor(private http: HttpClient) { }

  public loginUser(user: User){
    return this.http.post<any>(this.loginUrl, user);
  }

  public registerUser(user: User){
    return this.http.post<any>(this.registerUrl, user)
  }
}

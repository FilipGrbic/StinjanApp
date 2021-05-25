import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Lunch } from '../models/lunch';

@Injectable({
  providedIn: 'root'
})
export class LunchService {

  private lunchURL: string;

  constructor(private httpClient: HttpClient) { 
    this.lunchURL = 'http://localhost:4063/lunch/list';
  }

  getLunchList(): Observable<Lunch[]>{
    return this.httpClient.get<Lunch[]>(`${this.lunchURL}`);
  }
}

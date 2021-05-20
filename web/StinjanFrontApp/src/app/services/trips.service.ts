import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Trips } from '../models/trips';

@Injectable({
  providedIn: 'root'
})
export class TripsService {

  private tripsURL: string;

  constructor(private httpClient: HttpClient) { 
    this.tripsURL = 'http://localhost:4063/trips/list';
  }

  getTripsList(): Observable<Trips[]>{
    return this.httpClient.get<Trips[]>(`${this.tripsURL}`);
  }
}

import { Component, OnInit } from '@angular/core';
import { TripsService } from 'src/app/services/trips.service';
import { Trips } from '../../models/trips'

@Component({
  selector: 'app-trips',
  templateUrl: './trips.component.html',
  styleUrls: ['./trips.component.css']
})
export class TripsComponent implements OnInit {

  trips: Trips[];

  constructor(private tripsService: TripsService) { }

  ngOnInit(): void {
    this.getTrips();
  }

  private getTrips(){
    this.tripsService.getTripsList().subscribe(data => {
      this.trips = data;
    });
  }
}

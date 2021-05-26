import { Component, OnInit } from '@angular/core';
import { LunchService } from 'src/app/services/lunch.service';
import { Lunch } from '../../models/lunch'

@Component({
  selector: 'app-lunch',
  templateUrl: './lunch.component.html',
  styleUrls: ['./lunch.component.css']
})
export class LunchComponent implements OnInit {

  lunches: Lunch[];

  constructor(private lunchService: LunchService) { }

  ngOnInit(): void {
    this.getLunches();
  }

  private getLunches(){
    this.lunchService.getLunchList().subscribe(data => {
      this.lunches = data;
    });
  }
}

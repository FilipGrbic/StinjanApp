import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactComponent } from './components/contact/contact.component';
import { HomeComponent } from './components/home/home.component';
import { ApartmentsComponent } from './components/apartments/apartments.component';
import { TripsComponent } from './components/trips/trips.component';
import { LunchComponent } from './components/lunch/lunch.component';
import { GalleryComponent } from './components/gallery/gallery.component';

import {TripsService} from './services/trips.service';
import {LunchService} from './services/lunch.service';
import {ApartmentsService} from './services/apartments.service';
import { AboutComponent } from './components/about/about.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    ContactComponent,
    HomeComponent,
    ApartmentsComponent,
    TripsComponent,
    LunchComponent,
    GalleryComponent,
    AboutComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    TripsService,
    LunchService,
    ApartmentsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

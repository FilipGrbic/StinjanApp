import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { ApartmentsComponent } from './components/apartments/apartments.component';
import { ContactComponent } from './components/contact/contact.component';
import { GalleryComponent } from './components/gallery/gallery.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { LunchComponent } from './components/lunch/lunch.component';
import { RegisterComponent } from './components/register/register.component';
import { TripsComponent } from './components/trips/trips.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'aboutus', component: AboutComponent},
  {path: 'apartments', component: ApartmentsComponent},
  {path: 'lunch', component: LunchComponent},
  {path: 'trips', component: TripsComponent},
  {path: 'gallery', component: GalleryComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { LogInComponent } from './components/log-in/log-in.component';
import { HomeComponent } from './components/home/home.component';
import { AnnonceformComponent } from './components/annonceform/annonceform.component';
import { ForgetComponent } from './components/forget/forget.component';
import { MissionsComponent } from './components/missions/missions.component';
import { AnnoncesComponent } from './components/annonces/annonces.component';
import { NavComponent } from './components/nav/nav.component';
import { FooterComponent } from './components/footer/footer.component';
import { UnauthnavComponent } from './components/unauthnav/unauthnav.component';



const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'login', component: LogInComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home', component: HomeComponent },
  { path: 'formannonce', component: AnnonceformComponent },
  { path: 'forget', component: ForgetComponent },
  { path: 'missions', component: MissionsComponent },
  { path: 'annonce', component:AnnoncesComponent},
  { path: 'navbar', component:NavComponent},
  { path: 'footer', component:FooterComponent},
  { path: 'unauth', component:UnauthnavComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

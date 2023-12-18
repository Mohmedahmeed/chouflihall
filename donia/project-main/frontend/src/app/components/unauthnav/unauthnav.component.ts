import { Component} from '@angular/core';

@Component({
  selector: 'app-unauthnav',
  templateUrl: './unauthnav.component.html',
  styleUrls: ['./unauthnav.component.css']
})
export class UnauthnavComponent {
  isAuthenticated = false;
  userType: string;
 
  constructor() {}
 
 
  login(type: string): void {
     this.isAuthenticated = true;
     this.userType = type;
  }
 
  logout(): void {
     this.isAuthenticated = false;
     this.userType = '';
  }

}

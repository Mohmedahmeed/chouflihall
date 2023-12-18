import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  isAuthenticated = false;
  userType: string;
 
  constructor() {}
 
  ngOnInit(): void {}
 
  login(type: string): void {
     this.isAuthenticated = true;
     this.userType = type;
  }
 
  logout(): void {
     this.isAuthenticated = false;
     this.userType = '';
  }

}

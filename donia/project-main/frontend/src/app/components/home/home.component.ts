import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';


@Component({
 selector: 'app-home',
 templateUrl: './home.component.html',
 styleUrls: ['./home.component.css']
})
export class HomeComponent {
 constructor(public dialog: MatDialog) {}
 categories = [
  {title: 'Plumbing', img: 'assets/images/plombier.jpg'},
  {title: 'Electricity', img: 'assets/images/electr.PNG'},
  {title: 'Baby sitting', img: 'assets/images/babysitting.jpg'},
  {title: 'Paint', img: 'assets/images/paint.PNG'},
  {title: 'DIY', img: 'assets/images/diy.jpg'},
  {title: 'Others', img: 'assets/images/other.jpg'}
];
reviews = [
  { name: 'Rachel Green', text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', photoUrl: 'assets/images/customer1.webp' },
  { name: 'Chandler Bing', text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', photoUrl: 'assets/images/customer2.jpg' },
  { name: 'Joey Tribiani', text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', photoUrl: 'assets/images/customer3.jpg' },
];
 
}
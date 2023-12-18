import { Component } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'app-annonceform',
  templateUrl: './annonceform.component.html',
  styleUrls: ['./annonceform.component.css']
})
export class AnnonceformComponent {
  firstFormGroup = this._formBuilder.group({
    firstCtrl: ['', Validators.required],
  });
  secondFormGroup = this._formBuilder.group({
    secondCtrl: ['', Validators.required],
  });
  isLinear = true;

  constructor(private _formBuilder: FormBuilder) {}
  categories:string[]= [
      'Plumbing',
      'Electricity',
      'Baby sitting',
      'Paint',
      'DIY',
      'Others'
  ];

}

import { Component } from '@angular/core';
import { Smoothie } from '../smoothie';

@Component({
  selector: 'app-smoothie',
  templateUrl: './smoothie.component.html',
  styleUrls: ['./smoothie.component.css']
})
export class SmoothieComponent {
  smoothie : Smoothie = {
    id: 1,
    name: "Spinach",
    ingredients: [
      "Spinach",
      "Apples",
      "Bananas",
      "Milk"
    ]
  }
}

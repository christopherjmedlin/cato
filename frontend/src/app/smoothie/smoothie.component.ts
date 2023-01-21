import { Component } from '@angular/core';
import { Smoothie } from '../smoothie';
import { SmoothieService } from '../smoothie.service'

@Component({
  selector: 'app-smoothie',
  templateUrl: './smoothie.component.html',
  styleUrls: ['./smoothie.component.css']
})
export class SmoothieComponent {
  constructor(private smoothieService: SmoothieService) {}

  getSmoothie() : void {
    this.smoothie = this.smoothieService.getSmoothie(1);
  }

  ngOnInit(): void {
    this.getSmoothie();
  }

  smoothie : Smoothie = {
    id: 0,
    name: "",
    ingredients: []
  }
}

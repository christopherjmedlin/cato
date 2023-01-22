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
    this.smoothieService.getSmoothie(0)
        .subscribe(s => this.smoothie = s);
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

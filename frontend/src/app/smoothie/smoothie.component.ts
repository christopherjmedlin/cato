import { Component } from '@angular/core';
import { Smoothie } from '../smoothie';
import { SmoothieService } from '../smoothie.service'
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-smoothie',
  templateUrl: './smoothie.component.html',
  styleUrls: ['./smoothie.component.css']
})
export class SmoothieComponent {
  constructor(private smoothieService: SmoothieService,
              private route: ActivatedRoute) {}

  getSmoothie() : void {
    this.smoothieService.getSmoothie(this.id)
        .subscribe(s => this.smoothie = s);
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(paramMap => {
      this.id = Number(paramMap.get('id'));
      this.getSmoothie();
    });
  }

  smoothie : Smoothie = {
    id: 0,
    name: "",
    ingredients: []
  }
  id: number = -1;
}

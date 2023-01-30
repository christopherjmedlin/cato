import { Component } from '@angular/core';
import { ActivatedRoute, convertToParamMap } from '@angular/router';
import { Smoothie } from '../smoothie';
import { SmoothieService } from '../smoothie.service';

@Component({
  selector: 'app-smoothie-list',
  templateUrl: './smoothie-list.component.html',
  styleUrls: ['./smoothie-list.component.css']
})
export class SmoothieListComponent {
  constructor(private route: ActivatedRoute,
              private smoothieService : SmoothieService) {}

  ngOnInit() {
    this.route.queryParams
      .subscribe(params => {
        let paramMap = convertToParamMap(params);
        let ids = convertToParamMap(params).getAll("ingredientIds").map(Number);
        this.smoothieService.getSmoothiesByIngredientIds(ids).subscribe(s => {
          this.smoothies = s;
        })
      });
  }

  smoothies: Smoothie[] = []
}

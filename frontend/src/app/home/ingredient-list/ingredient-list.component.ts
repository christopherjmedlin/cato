import { Component, Input, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { Ingredient } from 'src/app/ingredient';

@Component({
  selector: 'app-ingredient-list',
  templateUrl: './ingredient-list.component.html',
  styleUrls: ['./ingredient-list.component.css']
})
export class IngredientListComponent {
  constructor(private router: Router) {}

  ngOnChanges(changes: SimpleChanges) {
    console.log(changes);
  }

  onSearchPressed() {
    this.router.navigate(
      ['list'],
      { queryParams: { ingredientIds: this.ingredients.map((i) => i.id)}}
    );
  }

  @Input() ingredients : Ingredient[] = []
}

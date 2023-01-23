import { Component } from '@angular/core';
import { Ingredient } from 'src/app/ingredient';

@Component({
  selector: 'app-ingredient-list',
  templateUrl: './ingredient-list.component.html',
  styleUrls: ['./ingredient-list.component.css']
})
export class IngredientListComponent {
  ingredients: Ingredient[] = [
    {id: 1, name: "Banana"}
  ]
}

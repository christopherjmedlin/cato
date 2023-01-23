import { Component } from '@angular/core';
import { Ingredient } from '../ingredient';
import { SearchComponent } from './search/search.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  addIngredient(i : Ingredient) {
    this.ingredients.push(i);
  }

  ingredients: Ingredient[] = []
}

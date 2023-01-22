import { Component } from '@angular/core';
import { Ingredient } from '../ingredient';
import { IngredientService } from '../ingredient.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  constructor(private ingredientService: IngredientService) {}

  onInputChange() {
    this.ingredientService.getIngredientsByName("a")
        .subscribe((is) => {this.ingredientSuggestions = is})

    this.ingredientSuggestions = [{id: 1, name: "Avocado"}]
  }

  ingredientSuggestions: Ingredient[] = [
    {id: 1, name: "Banana"},
    {id: 2, name: "Apple"}
  ]
}

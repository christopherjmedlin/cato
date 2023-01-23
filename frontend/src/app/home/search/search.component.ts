import { Component, EventEmitter, Output } from '@angular/core';
import { Ingredient } from '../../ingredient';
import { IngredientService } from '../../ingredient.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  constructor(private ingredientService: IngredientService) {}

  @Output() inputEvent = new EventEmitter<Ingredient>();

  onInputChange(event: KeyboardEvent) {
    if (event.key == "Enter") {
      let selected = (event.target as HTMLInputElement).value;
      for (let i of this.ingredientSuggestions) {
        if (i.name == selected) {
          this.inputEvent.emit(i);
          return;
        }
      }
    }

    this.ingredientService.getIngredientsByName((event.target as HTMLInputElement).value)
        .subscribe((is) => {this.ingredientSuggestions = is})

    this.ingredientSuggestions = [{id: 1, name: "Avocado"}]
  }

  ingredientSuggestions: Ingredient[] = [
    {id: 1, name: "Banana"},
    {id: 2, name: "Apple"}
  ]

  ingredient: Ingredient = {id : -1, name : ""}
}

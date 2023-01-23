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
      this.submit(selected);
    }

    this.ingredientService.getIngredientsByName((event.target as HTMLInputElement).value)
        .subscribe((is) => {this.ingredientSuggestions = is})

    this.ingredientSuggestions = [{id: 1, name: "Avocado"}]
  }

  submit(val: string) {
    for (let i of this.ingredientSuggestions) {
      if (i.name == val) {
        this.inputEvent.emit(i);
        return;
      }
    }
  }

  ingredientSuggestions: Ingredient[] = [
    {id: 1, name: "Banana"},
    {id: 2, name: "Apple"}
  ]

  ingredient: Ingredient = {id : -1, name : ""}
}

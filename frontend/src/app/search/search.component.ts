import { Component } from '@angular/core';
import { Ingredient } from '../ingredient';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {


  ingredientSuggestions: Ingredient[] = [
    {id: 1, name: "Banana"},
    {id: 2, name: "Apple"}
  ]
}

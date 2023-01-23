import { Component, Input, SimpleChanges } from '@angular/core';
import { Ingredient } from 'src/app/ingredient';

@Component({
  selector: 'app-ingredient-list',
  templateUrl: './ingredient-list.component.html',
  styleUrls: ['./ingredient-list.component.css']
})
export class IngredientListComponent {
  ngOnChanges(changes: SimpleChanges) {
    console.log(changes);
  }

  @Input() ingredients : Ingredient[] = []
}

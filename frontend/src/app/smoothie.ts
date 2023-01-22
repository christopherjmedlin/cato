import { Ingredient } from './ingredient';

export interface Smoothie {
  id: number;
  name: string;
  ingredients: Ingredient[];
}

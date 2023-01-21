import { Injectable } from '@angular/core'
import { Smoothie } from './smoothie'

@Injectable({
  providedIn: 'root'
})
export class SmoothieService {
  constructor() { }

  getSmoothie(id: number): Smoothie {
    return {
      id: 1,
      name: "Spinach",
      ingredients: [
        "Spinach",
        "Apples",
        "Bananas",
        "Milk"
      ]
    }
  }
}

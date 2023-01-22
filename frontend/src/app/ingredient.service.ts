import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ingredient } from './ingredient';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  constructor(private http: HttpClient) { }

  getIngredientsByName(name: string) : Observable<Ingredient[]> {
    let params = new HttpParams().set('name', name);
    return this.http.get<Ingredient[]>("http://localhost:8080/ingredients",
                                     { params: params });
  }
}

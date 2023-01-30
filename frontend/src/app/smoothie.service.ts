import { Injectable } from '@angular/core'
import { Smoothie } from './smoothie'
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http'
import { Observable, map } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class SmoothieService {
  constructor(
    private http: HttpClient,
  ) { }

  getSmoothie(id: number): Observable<Smoothie> {
    return this.http.get<Smoothie>("http://localhost:8080/smoothies/" + id);
  }

  getSmoothiesByIngredientIds(ingredientIds : number[]): Observable<Smoothie[]> {
    let ids : string = ingredientIds.map(n => n.toString()).join(",");
    let params = new HttpParams().set("ingredientIds", ids);
    return this.http.get<any>("http://localhost:8080/smoothies/ingredientSearch",
      {params: params}
    ).pipe(map(o => ((o["_embedded"]["tupleBackedMapList"] as Smoothie[]))));
  }
}

import { Injectable } from '@angular/core'
import { Smoothie } from './smoothie'
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class SmoothieService {
  constructor(
    private http: HttpClient,
  ) { }

  getSmoothie(id: number): Observable<Smoothie> {
    return this.http.get<Smoothie>("http://localhost:8080/smoothies/1");
  }
}

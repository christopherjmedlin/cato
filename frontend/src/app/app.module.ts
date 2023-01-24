import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { IngredientListComponent } from './home/ingredient-list/ingredient-list.component';
import { SearchComponent } from './home/search/search.component';
import { SmoothieComponent } from './smoothie/smoothie.component';
import { SmoothieListComponent } from './smoothie-list/smoothie-list.component';

@NgModule({
  declarations: [
    AppComponent,
    SmoothieComponent,
    IngredientListComponent,
    HomeComponent,
    SearchComponent,
    SmoothieListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


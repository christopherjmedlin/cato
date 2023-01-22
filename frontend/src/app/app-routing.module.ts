import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SearchComponent } from './search/search.component';
import { SmoothieComponent } from './smoothie/smoothie.component';

const routes: Routes = [
  { path: 'smoothie/:id', component: SmoothieComponent },
  { path: '', component: SearchComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

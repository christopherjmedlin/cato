import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SmoothieListComponent } from './smoothie-list/smoothie-list.component';
import { SmoothieComponent } from './smoothie/smoothie.component';

const routes: Routes = [
  { path: 'smoothie/:id', component: SmoothieComponent },
  { path: 'list', component: SmoothieListComponent},
  { path: '', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

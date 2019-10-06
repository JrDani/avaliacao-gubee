import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListaProdutosComponent } from './lista-produtos/lista-produtos.component';

const routes: Routes = [
  {path: '', component: ListaProdutosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

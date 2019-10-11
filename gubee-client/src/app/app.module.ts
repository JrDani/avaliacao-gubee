import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ListaProdutosComponent } from './lista-produtos/lista-produtos.component';
import { CheckboxGroupComponent } from './checkbox-group/checkbox-group.component';
import { ProductService } from './product.service';
import { StackService } from './stack.service';
import { MarketService } from './market.service';

@NgModule({
  declarations: [
    AppComponent,
    ListaProdutosComponent,
    CheckboxGroupComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
    FormsModule
  ],
  providers: [ProductService, StackService, MarketService],
  bootstrap: [AppComponent]
})
export class AppModule { }

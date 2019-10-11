import { Component, OnInit } from '@angular/core';
import {CheckboxItem} from '../checkbox-group/checkbox-item';
import { concat } from 'rxjs';

import { Product } from './product';
import { ProductService } from '../product.service';
import { MarketService } from '../market.service';
import { StackService } from '../stack.service';
import { Market } from './market';
import { Stack } from './stack';


@Component({
  selector: 'app-lista-produtos',
  templateUrl: './lista-produtos.component.html',
  styleUrls: ['./lista-produtos.component.css']
})
export class ListaProdutosComponent implements OnInit {

  produtos: Product[] = [];

  private stacks = new Array<CheckboxItem>();
  private targetMarket = new Array<CheckboxItem>();
  
  private stacks_query = [];
  private targetMarket_query = [];

  
  constructor(private productService: ProductService,
    private marketService: MarketService,
    private stackService: StackService) { }

  ngOnInit() {
    this.carregarStacks();    
    this.carregarMarkets();

    this.listarProduto();    
  }

  onStacksChange(value) {
    this.stacks_query = value;     
   }

   onTargetMarketChange(value) {
    this.targetMarket_query = value;    
   }

   filtrarProduto(){
    this.productService    
    .buscaComFiltro(this.montarQuery())
    .subscribe((data:Product[]) => { 
      this.produtos = data;       
    });
   }

   listarProduto(){
    this.productService    
    .list()
    .subscribe((data:Product[]) => {       
      this.produtos = data;       
    });
   }

   carregarStacks(){
    this.stackService    
    .list()
    .subscribe((data:Stack[]) => {    
      this.stacks = data.map(x => new CheckboxItem(x.id, x.name));
    });
   }

   carregarMarkets(){
    this.marketService    
    .list()
    .subscribe((data:Market[]) => {       
      this.targetMarket = data.map(x => new CheckboxItem(x.id, x.name));
    });
   }

  montarQuery():String{
    let query:String;

    if(this.stacks_query.length > 0 && this.targetMarket_query.length > 0){
      query = ("stack="+this.stacks_query.toString()+"&targetMarket=").concat(this.targetMarket_query.toString());      
    }else if(this.stacks_query.length > 0){
      query = "stack="+this.stacks_query.toString();
    }
    else if(this.targetMarket_query.length > 0){
      query = "targetMarket="+this.targetMarket_query.toString();
    }
    
    return query;
  }

}

import { Component, OnInit } from '@angular/core';
import { produtos } from '../data/produtos';
import {CheckboxItem} from '../checkbox-group/checkbox-item';

@Component({
  selector: 'app-lista-produtos',
  templateUrl: './lista-produtos.component.html',
  styleUrls: ['./lista-produtos.component.css']
})
export class ListaProdutosComponent implements OnInit {

  stacks_data = [
    { id: 1, name: 'PHP' },
    { id: 2, name: 'JAVA' }
  ];
  targetMarket_data = [
    { id: 1, name: 'Ecommerce' },
    { id: 2, name: 'ERP' }
  ];
  private stacks = new Array<CheckboxItem>();
  private targetMarket = new Array<CheckboxItem>();
  produtos = produtos;

  constructor() { }

  ngOnInit() {
    this.stacks = this.stacks_data.map(x => new CheckboxItem(x.id, x.name));
    this.targetMarket = this.targetMarket_data.map(x => new CheckboxItem(x.id, x.name));
  }

  onStacksChange(value) {
    console.log("Códigos de Stacks selecionados: "+value);
    //this.userModel.roles = value;
    //console.log('Model role:' , this.userModel.roles);
   }

   onTargetMarketChange(value) {
    console.log("Códigos de targetMarkets selecionados: "+value);
    //this.userModel.roles = value;
    //console.log('Model role:' , this.userModel.roles);
   }
  
  

}

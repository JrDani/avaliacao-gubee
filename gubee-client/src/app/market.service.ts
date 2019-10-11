import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Market } from './lista-produtos/market';

const uri = 'http://localhost:8081/target-markets';

@Injectable({
  providedIn: 'root'
})
export class MarketService {

  constructor(private httpClient: HttpClient) { }

  list(){   
    return this.httpClient
    .get<Market[]>(uri)        
  } 
}

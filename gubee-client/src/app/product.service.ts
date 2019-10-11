import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from './lista-produtos/product';

const uri = 'http://localhost:8081/produtos';

@Injectable()
export class ProductService {

  constructor(private httpClient: HttpClient) { }

  list(){   
    return this.httpClient
    .get<Product[]>(uri)        
  } 

  buscaComFiltro(query: String){
    return this.httpClient
    .get<Product[]>(uri+"/filtros?"+query); 
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Stack } from './lista-produtos/stack';

const uri = 'http://localhost:8081/stacks';

@Injectable({
  providedIn: 'root'
})
export class StackService {

  constructor(private httpClient: HttpClient) { }

  list(){   
    return this.httpClient
    .get<Stack[]>(uri)        
  } 

}

import { Stack } from './stack';

export interface Product{    
    id:number;
    productName:string;
    description:string;
    stack:Stack[];
    targetMarket:Array<Object>;     
}
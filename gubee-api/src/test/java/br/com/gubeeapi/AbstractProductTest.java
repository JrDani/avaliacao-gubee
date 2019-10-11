package br.com.gubeeapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.gubeeapi.domain.model.Product;
import br.com.gubeeapi.domain.model.Stack;
import br.com.gubeeapi.domain.model.TargetMarket;

public class AbstractProductTest {	
	
	protected final static List<Product> PRODUCTS = new ArrayList<>();
	
	public Product buildProduct() {
	   Product product = new Product();
	   Stack stack = new Stack();
	   Stack stack2 = new Stack();
	   List<Stack> stacks = new ArrayList<>();
	   
	   TargetMarket targetMarket = new TargetMarket();
	   List<TargetMarket> tms = new ArrayList<>();
	   
	   product.setProductName("Daniel job");
	   product.setDescription("Carrinho de compras integrador");	  
	   
	   stack.setId(1L);
	   stack.setName("PHP 7");		   
	   
	   stack2.setId(2L);
	   stack2.setName("Kibana");	   		   
	   
	   stacks.add(stack);
	   stacks.add(stack2);   
		   
	   product.setStack(stacks);		   
	   
	   targetMarket.setId(1L);
	   targetMarket.setName("Ecommerce");
	  
	   tms.add(targetMarket);
	   
	   product.setTargetMarket(tms);
	   
	   return product;
	}
	
	public void setId(Product product) {		
		if(product.getId() == null) {
			product.setId(1L);
		}else {
			product.setId(product.getId()+1L);
		}
			
	}
	
	public void buildProdutos() {
	
		Product product = buildProduct();
		setId(product);
		PRODUCTS.add(product);		
		
	}
	
	public void buildProdutos(Integer n) {
		for (int j = 0; j < n; j++) {
			Product product = buildProduct();
			setId(product);
			PRODUCTS.add(product);
		}
		
	}
}

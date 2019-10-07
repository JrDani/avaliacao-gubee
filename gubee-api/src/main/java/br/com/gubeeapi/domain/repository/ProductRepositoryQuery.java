package br.com.gubeeapi.domain.repository;

import java.util.List;

import br.com.gubeeapi.domain.model.Product;
import br.com.gubeeapi.domain.repository.Specification.ProductFilter;

public interface ProductRepositoryQuery {	
	
	public List<Product> filtrar(ProductFilter productFilter);
}

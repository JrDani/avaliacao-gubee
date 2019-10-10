package br.com.gubeeapi.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gubeeapi.domain.model.Product;
import br.com.gubeeapi.domain.repository.Specification.ProductFilter;

@Service
public interface ProductService {
	
	public List<Product> listarProdutos();
	
	public Product cadastrarProduto(Product product);
	
	public List<Product> buscarProduto(ProductFilter productFilter);
	
}

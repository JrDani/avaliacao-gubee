package br.com.gubeeapi.api.infrasctructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gubeeapi.domain.model.Product;
import br.com.gubeeapi.domain.repository.ProductRepository;
import br.com.gubeeapi.domain.repository.Specification.ProductFilter;
import br.com.gubeeapi.domain.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> listarProdutos() {
		
		return productRepository.findAll();
	}

	@Override
	public Product cadastrarProduto(Product product) {
		
		Product produtoSalvo = productRepository.save(product);		
		return produtoSalvo;
	}

	@Override
	public List<Product> buscarProduto(ProductFilter productFilter) {

		return productRepository.filtrar(productFilter);
	}

}

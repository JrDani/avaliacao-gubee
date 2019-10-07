package br.com.gubeeapi.api.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gubeeapi.domain.model.Product;
import br.com.gubeeapi.domain.model.Stack;
import br.com.gubeeapi.domain.repository.ProductRepository;
import br.com.gubeeapi.domain.repository.Specification.ProductFilter;

@RestController
@RequestMapping("/produtos")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public ResponseEntity<List<Product>> listarProdutos(){
		List<Product> produtos = productRepository.findAll();
		return ResponseEntity.ok(produtos);
	}
	
	@PostMapping
	public ResponseEntity<Product> cadastrarProduto(@RequestBody Product product, HttpServletResponse response){
		Product produtoSalvo = productRepository.save(product);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(produtoSalvo.getId()).toUri();
		
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(product);
	}
	
	@GetMapping("/query")
	public List<Product> buscarProduto(ProductFilter productFilter) {
		return productRepository.filtrar(productFilter);
	}
}

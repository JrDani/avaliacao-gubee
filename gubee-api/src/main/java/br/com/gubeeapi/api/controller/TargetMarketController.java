package br.com.gubeeapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gubeeapi.domain.model.TargetMarket;
import br.com.gubeeapi.domain.repository.TargetMarketRepository;

@RestController
@RequestMapping("/target-markets")
public class TargetMarketController {
	@Autowired
	private TargetMarketRepository marketRepository;
	
	@GetMapping 
	public ResponseEntity<List<TargetMarket>> listarStacks(){
		List<TargetMarket> markets = marketRepository.findAll();
		return ResponseEntity.ok(markets);
	}
}

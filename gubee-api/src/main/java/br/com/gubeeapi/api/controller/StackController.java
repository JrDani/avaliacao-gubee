package br.com.gubeeapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gubeeapi.domain.model.Stack;
import br.com.gubeeapi.domain.repository.StackRepository;

@RestController
@RequestMapping("/stacks")
public class StackController {
	
	@Autowired
	private StackRepository stackRepository;
	
	@GetMapping
	public ResponseEntity<List<Stack>> listarStacks(){
		List<Stack> stacks = stackRepository.findAll();
		return ResponseEntity.ok(stacks);
	}
}

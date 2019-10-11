package br.com.gubeeapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gubeeapi.domain.model.Stack;

public interface StackRepository extends JpaRepository<Stack, Long> {

}

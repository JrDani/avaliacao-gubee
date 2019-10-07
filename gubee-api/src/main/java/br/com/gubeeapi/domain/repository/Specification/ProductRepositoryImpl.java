package br.com.gubeeapi.domain.repository.Specification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.gubeeapi.domain.model.Product;
import br.com.gubeeapi.domain.repository.ProductRepositoryQuery;

public class ProductRepositoryImpl implements ProductRepositoryQuery {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Product> filtrar(ProductFilter productFilter) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> criteria = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = criteria.from(Product.class);
		
		Predicate[] predicates = toPredicate(productFilter, criteriaBuilder, root);
		criteria.where(predicates);
		
		TypedQuery<Product> query = entityManager.createQuery(criteria);
		
		return query.getResultList();
	}
	
	public Predicate[] toPredicate(ProductFilter productFilter, CriteriaBuilder criteriaBuilder, Root<Product> root) {
	
		List<Predicate> predicates = new ArrayList<>();
		
		//https://stackoverflow.com/questions/42530677/jpa-criteria-builder-in-clause-query/42531461
		
		if (productFilter.getStack().length > 0) {
			Expression<String> parentExpression = root.get("stack");
			
			Predicate parentPredicate = parentExpression.in(					
					Arrays.asList(productFilter.getStack())
					.stream()
					.map(s -> s.toLowerCase())
					.collect(Collectors.toList())
			);
			predicates.add(parentPredicate);
        } 
		
		if (productFilter.getTargetMarket().length > 0) {
			Expression<String> parentExpression = root.get("targetMarket");
			
			Predicate parentPredicate = parentExpression.in(					
					Arrays.asList(productFilter.getTargetMarket())
					.stream()
					.map(s -> s.toLowerCase())
					.collect(Collectors.toList())
			);
			
			predicates.add(parentPredicate);
        } 
       		
        return predicates.toArray(new Predicate[predicates.size()]);
	}

	

}

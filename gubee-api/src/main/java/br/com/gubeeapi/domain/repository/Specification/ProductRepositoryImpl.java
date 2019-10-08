package br.com.gubeeapi.domain.repository.Specification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.gubeeapi.domain.model.Product;
import br.com.gubeeapi.domain.model.Stack;
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
		criteria.where(criteriaBuilder.or(predicates));
		criteria.distinct(true);
		
		TypedQuery<Product> query = entityManager.createQuery(criteria);
		
		return query.getResultList();
	}
	
	public Predicate[] toPredicate(ProductFilter productFilter, CriteriaBuilder criteriaBuilder, Root<Product> root) {
	
		List<Predicate> predicates = new ArrayList<>();		
		
		if (productFilter.getStack() != null && productFilter.getStack().length > 0) {
			
			Join<Product, Stack> joinOptions = root.join("stack", JoinType.LEFT);
			
			predicates.addAll(Arrays.asList(productFilter.getStack())
				.stream()
				.map(s -> {
					Predicate p = criteriaBuilder.like(criteriaBuilder.lower(joinOptions.get("name")), "%"+s.toLowerCase()+"%");
					return p;
				})
				.collect(Collectors.toCollection(ArrayList::new))
			);
										
        } 
		
		if (productFilter.getTargetMarket() != null && productFilter.getTargetMarket().length > 0) {
			
			Join<Product, Stack> joinOptions = root.join("targetMarket", JoinType.LEFT);
			
			predicates.addAll(Arrays.asList(productFilter.getTargetMarket())
				.stream()
				.map(s -> {
					Predicate p = criteriaBuilder.like(criteriaBuilder.lower(joinOptions.get("name")), "%"+s.toLowerCase()+"%");
					return p;
				})
				.collect(Collectors.toCollection(ArrayList::new))
			);
        } 

		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	

}

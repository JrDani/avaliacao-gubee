package br.com.gubeeapi.domain.repository.Specification;

public class ProductFilter {
	
	private String[] targetMarket;
	private String[] stack;
	
	public String[] getTargetMarket() {
		return targetMarket;
	}
	public void setTargetMarket(String[] targetMarket) {
		this.targetMarket = targetMarket;
	}
	public String[] getStack() {
		return stack;
	}
	public void setStack(String[] stack) {
		this.stack = stack;
	}
	
	
	
}

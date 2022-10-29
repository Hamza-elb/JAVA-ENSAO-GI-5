package com.ensao.java.advanced.exercices.product;

public class Product extends AbstractProduct {
	
	@Override
	public Product clone() throws CloneNotSupportedException {
		Product p = new Product();
		p.setId(this.getId());
		p.setCategory(this.getCategory());
		return p;
	}

	public Product() {
		super();
	}
	
	
}
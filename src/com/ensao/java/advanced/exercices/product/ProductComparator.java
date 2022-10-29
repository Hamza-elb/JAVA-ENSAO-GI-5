package com.ensao.java.advanced.exercices.product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
	public final boolean byPrice;
	
	public ProductComparator() {
		this.byPrice = false;
	}
	
	public ProductComparator(boolean byPrice) {

		this.byPrice = byPrice;
	}
	
	@Override
	public int compare(Product productA, Product productB) {
		//Comparator<Product>
		if(byPrice){
			return Comparator.comparing(Product::getPrice).compare(productA, productB);
		}
		return Comparator.comparing(Product::getName).compare(productA, productB);
	}
}

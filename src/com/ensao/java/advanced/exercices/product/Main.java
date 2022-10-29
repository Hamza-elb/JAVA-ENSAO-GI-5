package com.ensao.java.advanced.exercices.product;

import java.util.Collection;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Product computer = new Product();
		computer.setId(1);
		computer.setName("Computers");
		computer.setPrice(400.00);
		computer.setCategory("IT");
		
		Stock stock = new Stock(new ProductComparator() );
		stock.add(computer);
		Map<String, Product> groupedByCategory = stock.groupByCategory();
		Collection<String> productsNamesOnly = stock.map(product -> product.getName());
		Object foundProduct = stock.findProduct("Computer");
		//Discount discount = (product, discount1) ->
		//stock.discount(discount, 10);
		Stock expensiveThanComputer = stock.moreExpensiveThan(computer);
		
		Stock filtered = stock.filter(null); // to complete
		
		
	}
}

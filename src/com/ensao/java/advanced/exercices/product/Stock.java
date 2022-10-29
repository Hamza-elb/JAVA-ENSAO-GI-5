package com.ensao.java.advanced.exercices.product;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stock extends TreeSet<Product> {
	private static final ProductComparator COMPARATOR = new ProductComparator();

	public Stock(Comparator<Product> comparator) {
		super(comparator);
	}
	public Stock() {
		this(COMPARATOR);
	}

	public Stock filter(Predicate<Product> predicate) {
		return this.stream()
				.filter(predicate)
				.collect(Collectors.toCollection(Stock::new));
	}

	public Stock inverserFiltre(Predicate<Product> predicate) {
		return filter(predicate.negate());
	}
	
	public void discount(Discount discount, double b) {
		Consumer<Product> consumer = product -> discount.discount(product, b);
		this.forEach(consumer);
	}
	
	public <R> Collection<R> map(Function<Product, R> mapper) {
		return this.stream()
				.map(mapper)
				.collect(Collectors.toList());
	}
	
	public void print(ProductPrinter printer) {
		this.stream().forEach(printer::print);
	}
	
	public Map<String, Product> groupByCategory() {
		return this.stream()
				.collect(Collectors.toMap(Product::getCategory, Function.identity()));
		
	}
	Optional<Product> findProduct(String name) {
		return this.stream()
				.filter(product -> product.getName().equals(name))
				.findFirst();
	}
	
	public Stock moreExpensiveThan(Product product) {
		return this.stream()
				.filter(p -> p.getPrice() > product.getPrice())
				.collect(Collectors.toCollection(Stock::new));
	}
	
	public Collection<Product> sorted() {
		return stream()
				.sorted(COMPARATOR)
				.collect(Collectors.toList());
	}
}

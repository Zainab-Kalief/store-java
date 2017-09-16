package com.wura.store.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
	        name = "categories_products", 
	        joinColumns = @JoinColumn (name = "category_id"), 
	        inverseJoinColumns = @JoinColumn(name = "product_id")
	    )
	private List<Product> products = new ArrayList<>();
	
	public Category() {}
	public Category(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products.add(products);
	}
	
}

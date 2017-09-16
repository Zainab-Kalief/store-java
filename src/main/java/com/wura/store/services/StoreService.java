package com.wura.store.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wura.store.models.Category;
import com.wura.store.models.Product;
import com.wura.store.repository.CategoryRepository;
import com.wura.store.repository.ProductRepository;
import javax.persistence.EntityManager;

@Service
public class StoreService {
	private CategoryRepository categoryRepo;
	private ProductRepository productRepo;
	protected EntityManager em;
	
	public StoreService(CategoryRepository categoryRepo, ProductRepository productRepo, EntityManager em) {
		this.categoryRepo = categoryRepo;
		this.productRepo = productRepo;
		this.em = em;
	}
	public void addProduct(Product product) {
		productRepo.save(product);
	}
	public List<Product> allProducts() {
		return (List<Product>) productRepo.findAll();
	}
	public void addCategory(Category category) {
		categoryRepo.save(category);
	}
	public List<Category> allCategories() {
		return (List<Category>) categoryRepo.findAll();
	}
	public Product findProduct(Long id) {
		return productRepo.findOne(id);
	}
	public Category findCategory(Long id) {
		return categoryRepo.findOne(id);
	}
	public void add(Product product, Category category) {
		product.getCategories().add(category);
		productRepo.save(product);
		categoryRepo.save(category);
	}
	
}

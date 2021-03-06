package com.wura.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wura.store.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
}

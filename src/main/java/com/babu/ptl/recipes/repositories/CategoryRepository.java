package com.babu.ptl.recipes.repositories;

import com.babu.ptl.recipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}

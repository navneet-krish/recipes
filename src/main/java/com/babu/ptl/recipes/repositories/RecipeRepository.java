package com.babu.ptl.recipes.repositories;

import com.babu.ptl.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}

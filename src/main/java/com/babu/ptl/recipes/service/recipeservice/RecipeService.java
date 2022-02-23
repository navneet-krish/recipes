package com.babu.ptl.recipes.service.recipeservice;

import com.babu.ptl.recipes.commands.RecipeCommand;
import com.babu.ptl.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(long l);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}

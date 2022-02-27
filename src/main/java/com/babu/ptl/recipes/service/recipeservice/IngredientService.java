package com.babu.ptl.recipes.service.recipeservice;



import com.babu.ptl.recipes.commands.IngredientCommand;
import com.babu.ptl.recipes.domain.Ingredient;

import java.util.Set;

public interface IngredientService {

    Set<Ingredient> getIngredient();

    IngredientCommand findByRecipeIdAndIngredientId(long lr, long li);

    IngredientCommand findCommandById(long l);

    IngredientCommand saveRecipeCommand(IngredientCommand ingredientCommand);

    void deleteById(long idToDelete);
}

package com.babu.ptl.recipes.service.recipeservice;



import com.babu.ptl.recipes.commands.IngredientCommand;
import com.babu.ptl.recipes.domain.Ingredient;

import java.util.Set;

public interface IngredientService {



    IngredientCommand findByRecipeIdAndIngredientId(long lr, long li);



    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);

    void deleteById(long lr, long li);


}

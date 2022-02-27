package com.babu.ptl.recipes.service;

import com.babu.ptl.recipes.commands.IngredientCommand;
import com.babu.ptl.recipes.converters.IngredientToIngredientCommand;
import com.babu.ptl.recipes.domain.Ingredient;
import com.babu.ptl.recipes.domain.Recipe;
import com.babu.ptl.recipes.repositories.RecipeRepository;
import com.babu.ptl.recipes.service.recipeservice.IngredientService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand,
                                 RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }


    @Override
    public Set<Ingredient> getIngredient() {
        return null;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(long lrecipe, long lingredient) {

        Optional<Recipe> optionalRecipe = recipeRepository.findById(lrecipe);
        if(optionalRecipe.isEmpty()){
            //log error
        }

        Recipe recipe = optionalRecipe.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(lingredient))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        return ingredientCommandOptional.get();
    }

    @Override
    public IngredientCommand findCommandById(long l) {
        return null;
    }

    @Override
    public IngredientCommand saveRecipeCommand(IngredientCommand ingredientCommand) {
        return null;
    }

    @Override
    public void deleteById(long idToDelete) {

    }
}

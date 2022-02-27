package com.babu.ptl.recipes.service;

import com.babu.ptl.recipes.commands.IngredientCommand;
import com.babu.ptl.recipes.converters.IngredientCommandToIngredient;
import com.babu.ptl.recipes.converters.IngredientToIngredientCommand;
import com.babu.ptl.recipes.converters.UnitOfMeasureCommandToUnitOfMeasure;
import com.babu.ptl.recipes.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.babu.ptl.recipes.domain.Ingredient;
import com.babu.ptl.recipes.domain.Recipe;
import com.babu.ptl.recipes.repositories.RecipeRepository;
import com.babu.ptl.recipes.repositories.UnitOfMeasureRepository;
import com.babu.ptl.recipes.service.recipeservice.IngredientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class testIngredientServiceImpl {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;



    IngredientService ingredientService;

    //init converters
    /*public testIngredientServiceImpl(IngredientCommandToIngredient ingredientCommandToIngredient,
                                     IngredientToIngredientCommand  ingredientToIngredientCommand) {
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }*/

    public testIngredientServiceImpl() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

  /*  public testIngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }*/

    @BeforeEach
    public void setUp()  {
        MockitoAnnotations.openMocks(this);

        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, recipeRepository,
                unitOfMeasureRepository, ingredientCommandToIngredient);
    }

    @Test
    public void findByRecipeIdAndId()  {
    }

    @Test
    public void findByRecipeIdAndRecipeIdHappyPath()  {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(1L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        //then
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

        //when
        assertEquals(Long.valueOf(3L), ingredientCommand.getId());
        assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyLong());
    }

    @Test
    public void testSaveRecipeCommand(){
        IngredientCommand command = new IngredientCommand();
        command.setId(3L);
        command.setRecipeId(2L);

        Optional<Recipe> recipeOptional = Optional.of(new Recipe());

        Recipe savedRecipe = new Recipe();
        savedRecipe.addIngredient(new Ingredient());
        savedRecipe.getIngredients().iterator().next().setId(3L);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        when(recipeRepository.save(any())).thenReturn(savedRecipe);

        //when
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        //then
        assertEquals(Long.valueOf(3L), savedCommand.getId());
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, times(1)).save(any(Recipe.class));

    }


}

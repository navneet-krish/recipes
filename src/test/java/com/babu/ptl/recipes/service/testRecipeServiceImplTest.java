package com.babu.ptl.recipes.service;

import com.babu.ptl.recipes.domain.Recipe;
import com.babu.ptl.recipes.repositories.RecipeRepository;
import com.babu.ptl.recipes.service.recipeservice.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class testRecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
            MockitoAnnotations.openMocks(this);

          recipeService = new RecipeServiceImpl(recipeRepository);

    }

    @Test
    public void getRecipeByIdTest(){
        Recipe recipe = new Recipe();
        recipe.setId(1l);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe returnedRecipe = recipeService.findById(1l);

        assertNotNull(returnedRecipe);
        assertNotNull(returnedRecipe,"Null Recipe Returned");
        verify(recipeRepository).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    void getRecipes() {

        Recipe recipe = new Recipe();
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipeSet);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();


    }
}
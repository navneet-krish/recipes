package com.babu.ptl.recipes.controller;

import com.babu.ptl.recipes.domain.Recipe;
import com.babu.ptl.recipes.service.recipeservice.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RecipeControllerTest {

    @Mock
    RecipeService recipeService;


    RecipeController recipeController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        recipeController = new RecipeController(recipeService);
    }

    @Test
    public void testGetRecipe() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        when(recipeService.findById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/1/show")).
                andExpect(status().isOk()).
                andExpect(view().name("recipe/show")).
                andExpect(model().attributeExists("recipe"))
                ;
    }
}

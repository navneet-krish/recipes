package com.babu.ptl.recipes.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void getId() {

        long idValue = 4L;
        category.setId(idValue);

        assertEquals(idValue,category.getId());
    }

    @Test
    void getDescription() {

        String description = "Punjabi";
        category.setDescription(description);

        assertEquals(description,category.getDescription());
    }

    @Test
    void getRecipeSet() {

        Set<Recipe> testRecipe = new HashSet<>();
        category.setRecipeSet(testRecipe);

        assertEquals(testRecipe,category.getRecipeSet());

    }
}
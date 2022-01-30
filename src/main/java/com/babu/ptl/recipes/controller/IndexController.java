package com.babu.ptl.recipes.controller;

import com.babu.ptl.recipes.domain.Category;
import com.babu.ptl.recipes.domain.UnitOfMeasure;
import com.babu.ptl.recipes.repositories.CategoryRepository;
import com.babu.ptl.recipes.repositories.RecipeRepository;
import com.babu.ptl.recipes.repositories.UnitOfMeasureRepository;
import com.babu.ptl.recipes.service.recipeservice.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}

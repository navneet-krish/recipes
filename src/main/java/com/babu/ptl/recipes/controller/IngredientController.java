package com.babu.ptl.recipes.controller;

import com.babu.ptl.recipes.service.recipeservice.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;

    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeid}/ingredients")
    public String listIngredients(@PathVariable String recipeid, Model model){
        log.debug("listing the ingredients");

        model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(recipeid)));
        return "recipe/ingredient/list";
    }
}

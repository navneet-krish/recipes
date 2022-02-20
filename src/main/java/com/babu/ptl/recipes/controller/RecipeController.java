package com.babu.ptl.recipes.controller;

import com.babu.ptl.recipes.service.recipeservice.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model){

             model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }

}

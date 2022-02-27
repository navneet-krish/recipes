package com.babu.ptl.recipes.controller;

import com.babu.ptl.recipes.commands.IngredientCommand;
import com.babu.ptl.recipes.service.recipeservice.IngredientService;
import com.babu.ptl.recipes.service.recipeservice.RecipeService;
import com.babu.ptl.recipes.service.recipeservice.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeid}/ingredients")
    public String listIngredients(@PathVariable String recipeid, Model model){
        log.debug("listing the ingredients");

        model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(recipeid)));
        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeid}/ingredient/{ingredientid}/show")
    public String ShowIngredient(@PathVariable String recipeid, @PathVariable String ingredientid, Model model){
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeid),
                Long.valueOf(ingredientid)));

        return "recipe/ingredient/show";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeid}/ingredient/{ingredientid}/update")
    public String updateRecipeIngredient(@PathVariable String recipeid, @PathVariable String ingredientid, Model model){
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeid),
                Long.valueOf(ingredientid)));
        model.addAttribute("uomList",unitOfMeasureService.listAllUoms() );

        return "recipe/ingredient/ingredientform";
    }

    @PostMapping("/recipe/{recipeid}/ingredient")
   public String saveOrUpdate(@ModelAttribute IngredientCommand ingredientCommand){
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(ingredientCommand);

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }
}

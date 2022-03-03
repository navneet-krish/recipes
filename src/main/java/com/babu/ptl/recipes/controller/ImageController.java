package com.babu.ptl.recipes.controller;

import com.babu.ptl.recipes.service.recipeservice.ImageService;
import com.babu.ptl.recipes.service.recipeservice.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    private final ImageService imageService;
    private final RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("recipe/{recipeid}/image")
    public String showUploadForm(@PathVariable String recipeid, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeid)));

        return "/recipe/imageuploadform";
    }

    @PostMapping("recipe/{recipeid}/image")
    public String handleImagePost (@PathVariable String recipeid, @RequestParam("imagefile")MultipartFile file){
        imageService.saveImageFile(Long.valueOf(recipeid), file);

        return "redirect:/recipe/" + recipeid + "/show";
    }
}

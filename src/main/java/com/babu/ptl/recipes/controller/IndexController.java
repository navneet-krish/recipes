package com.babu.ptl.recipes.controller;

import com.babu.ptl.recipes.domain.Category;
import com.babu.ptl.recipes.domain.UnitOfMeasure;
import com.babu.ptl.recipes.repositories.CategoryRepository;
import com.babu.ptl.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository ;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("Indian");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Swad Anusar");

        System.out.println("Cat Id is :" + categoryOptional.get().getId());
        System.out.println("UOM Id is :" + unitOfMeasureOptional.get().getId());


        return "index";
    }
}

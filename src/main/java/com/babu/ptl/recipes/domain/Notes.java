package com.babu.ptl.recipes.domain;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipeNotes() {
        return recipe;
    }

    public void setRecipeNotes(Recipe recipeNotes) {
        this.recipe = recipeNotes;
    }

    public String getNotes() {
        return recipeNotes;
    }

    public void setNotes(String notes) {
        this.recipeNotes = notes;
    }
}

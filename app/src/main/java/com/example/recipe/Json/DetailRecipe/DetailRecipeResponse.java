package com.example.recipe.Json.DetailRecipe;

import java.util.List;

public class DetailRecipeResponse {
    List<DetailRecipe> meals;

    public List<DetailRecipe> getMeals() {
        return meals;
    }

    public void setMeals(List<DetailRecipe> meals) {
        this.meals = meals;
    }
}

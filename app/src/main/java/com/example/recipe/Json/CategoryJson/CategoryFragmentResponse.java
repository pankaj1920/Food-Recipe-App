package com.example.recipe.Json.CategoryJson;

import java.util.List;

public class CategoryFragmentResponse {
    List<CategoryFragment> meals;

    public List<CategoryFragment> getMeals() {
        return meals;
    }

    public void setMeals(List<CategoryFragment> meals) {
        this.meals = meals;
    }
}

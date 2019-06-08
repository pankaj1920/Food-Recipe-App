package com.example.recipe;

import com.example.recipe.Json.CategoryJson.CategoryFragmentResponse;
import com.example.recipe.Json.CategoryTabs.TabCategoryResponse;
import com.example.recipe.Json.DetailRecipe.DetailRecipeResponse;
import com.example.recipe.Json.HomePageJson.LatestMealResponse;
import com.example.recipe.Json.HomePageJson.HomeCategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeHomeApi {

    @GET("categories.php")
    Call<HomeCategoryResponse> getCategories();

    @GET("latest.php")
    Call<LatestMealResponse> getLatestMeal();

    @GET("list.php")
    Call<TabCategoryResponse> getTablist(@Query("c") String abc);

    @GET("filter.php")
    Call<CategoryFragmentResponse> getCategory(@Query("c") String foodItem);

   @GET("search.php")
    Call<DetailRecipeResponse> getRecipe(@Query("s") String Arrabiata);

    @GET("lookup.php")
    Call<DetailRecipeResponse> getDetailRecipe(@Query("i")Integer RecipeId);

}

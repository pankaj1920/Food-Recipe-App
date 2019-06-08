package com.example.recipe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.recipe.BaseClient;
import com.example.recipe.Json.DetailRecipe.DetailRecipeResponse;
import com.example.recipe.Json.DetailRecipe.DetailRecyclerAdapter;
import com.example.recipe.R;
import com.example.recipe.RecipeHomeApi;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    RecyclerView Detail_Recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Detail_Recycler = (RecyclerView)findViewById(R.id.Detail_Recycler);
        Detail_Recycler.setLayoutManager(new LinearLayoutManager(this));
        getRecipe();

    }

    private void getRecipe() {

        Integer sessionId = Integer.valueOf(getIntent().getStringExtra("EXTRA_SESSION_ID"));

        RecipeHomeApi recipeHomeApi = BaseClient.getBaseClient().create(RecipeHomeApi.class);
        Call<DetailRecipeResponse> call = recipeHomeApi.getDetailRecipe(sessionId);

        call.enqueue(new Callback<DetailRecipeResponse>() {
            @Override
            public void onResponse(Call<DetailRecipeResponse> call, Response<DetailRecipeResponse> response) {
                if (response.isSuccessful() && HttpURLConnection.HTTP_OK==response.code()){
                    DetailRecipeResponse abd = response.body();

                    DetailRecyclerAdapter adapter = new DetailRecyclerAdapter(abd.getMeals());
                    Detail_Recycler.setAdapter(adapter);
                }else {
                    Toast.makeText(DetailActivity.this, "Unscuessfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DetailRecipeResponse> call, Throwable t) {

                Toast.makeText(DetailActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
            }
        });

    }

}

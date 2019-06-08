package com.example.recipe.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.recipe.BaseClient;
import com.example.recipe.Json.HomePageJson.LatestItem;
import com.example.recipe.Json.HomePageJson.LatestMealResponse;
import com.example.recipe.RecipeHomeApi;
import com.example.recipe.Json.HomePageJson.HomeCategoryResponse;
import com.example.recipe.R;
import com.example.recipe.Json.HomePageJson.HomeCategoryRecyclerAdapter;
import com.example.recipe.Json.HomePageJson.MealViewPagerAdapter;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycle;
    ViewPager viewPager;
    ImageView ic_fav,ic_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ic_fav= (ImageView)findViewById(R.id.ic_fav);
        ic_share = (ImageView)findViewById(R.id.ic_share);

        recycle = findViewById(R.id.recycle);
        recycle.setLayoutManager(new GridLayoutManager(this, 3));

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        getRecipe();
        getMeal();

        //Settin onClickListner on Favroite icon
        ic_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FavoriteActivity.class);
                startActivity(intent);
            }
        });

        //Setting OnClick Listner In share Icon

        ic_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String url = "https://bohrapankaj@gmail.com";
                intent.putExtra(Intent.EXTRA_SUBJECT,"abc");
                intent.putExtra(Intent.EXTRA_TEXT,url);
                startActivity(intent);
            }
        });

    }

    private void getRecipe() {

        RecipeHomeApi recipeHomeApi = BaseClient.getBaseClient().create(RecipeHomeApi.class);
        Call<HomeCategoryResponse> call = recipeHomeApi.getCategories();

        call.enqueue(new Callback<HomeCategoryResponse>() {
            @Override
            public void onResponse(Call<HomeCategoryResponse> call, Response<HomeCategoryResponse> response) {
                if (response.isSuccessful() && HttpURLConnection.HTTP_OK == response.code()) {
                    HomeCategoryResponse abc = response.body();
                    HomeCategoryRecyclerAdapter adapter = new HomeCategoryRecyclerAdapter(abc.getCategories());
                    recycle.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Unsucessful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HomeCategoryResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Try Later", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMeal() {
        RecipeHomeApi recipeHomeApi1 = BaseClient.getBaseClient().create(RecipeHomeApi.class);
        Call<LatestMealResponse> callMeal = recipeHomeApi1.getLatestMeal();
        callMeal.enqueue(new Callback<LatestMealResponse>() {
            @Override
            public void onResponse(Call<LatestMealResponse> call, Response<LatestMealResponse> response) {

                if (response.isSuccessful() && HttpURLConnection.HTTP_OK == response.code()) {
                    final LatestMealResponse xyz = response.body();

                    final MealViewPagerAdapter adapter = new MealViewPagerAdapter(xyz.getMeals());
                    viewPager.setAdapter(adapter);
                    viewPager.setPadding(0, 0, 150, 0);

                     final ImageView viewPagerImages = (ImageView)findViewById(R.id.viewPagerImages);

                } else {
                    Toast.makeText(MainActivity.this, "Unscessfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LatestMealResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "TryAgain", Toast.LENGTH_SHORT).show();

            }
        });
    }

    //Setting menu on MainActivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_page_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}

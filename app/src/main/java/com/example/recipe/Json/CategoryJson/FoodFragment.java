package com.example.recipe.Json.CategoryJson;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.recipe.BaseClient;
import com.example.recipe.Json.DetailRecipe.DetailRecipe;
import com.example.recipe.RecipeHomeApi;
import com.example.recipe.R;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {
    String title;
    RecyclerView CategoryRecycle;
    CategoryRecyclerAdapter adapter;

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle data = getArguments();
        title = data.getString("title");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_tab_food, container, false);


        CategoryRecycle = (RecyclerView)view.findViewById(R.id.CategoryRecycle);
        CategoryRecycle.setLayoutManager(new GridLayoutManager(getActivity(),2));

        getFoodItem();

        return view;
    }

    private void getFoodItem() {
        RecipeHomeApi recipeHomeApi = BaseClient.getBaseClient().create(RecipeHomeApi.class);
        Call<CategoryFragmentResponse> call = recipeHomeApi.getCategory(title);
        call.enqueue(new Callback<CategoryFragmentResponse>() {
            @Override
            public void onResponse(Call<CategoryFragmentResponse> call, Response<CategoryFragmentResponse> response) {

                if (response.isSuccessful() && HttpURLConnection.HTTP_OK==response.code()){

                    CategoryFragmentResponse psb = response.body();
                    adapter = new CategoryRecyclerAdapter(psb.getMeals());
                    CategoryRecycle.setAdapter(adapter);
                }else {
                    Toast.makeText(getActivity(), "Uncessfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CategoryFragmentResponse> call, Throwable t) {

                Toast.makeText(getActivity(), "Try Again", Toast.LENGTH_SHORT).show();
            }
        });

    }

}

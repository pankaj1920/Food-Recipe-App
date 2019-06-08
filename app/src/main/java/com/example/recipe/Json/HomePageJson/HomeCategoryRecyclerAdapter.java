package com.example.recipe.Json.HomePageJson;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recipe.Activity.CategoryActivity;
import com.example.recipe.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeCategoryRecyclerAdapter extends RecyclerView.Adapter<HomeCategoryRecyclerAdapter.Recipe_VH> {
List<HomeCategories> list;

    public HomeCategoryRecyclerAdapter(List<HomeCategories> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Recipe_VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.homepage_recycler_item,viewGroup,false);
        return new Recipe_VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recipe_VH recipe_vh, int i) {

        HomeCategories homeCategories = list.get(i);
        recipe_vh.meal_name.setText(homeCategories.getStrCategory());
        Picasso.with(recipe_vh.meal_name.getContext()).load(list.get(i).getStrCategoryThumb())
                .into(recipe_vh.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Recipe_VH extends RecyclerView.ViewHolder{
        TextView meal_name;
        ImageView imageView;
        public Recipe_VH(@NonNull final View itemView) {
            super(itemView);
            meal_name = (TextView)itemView.findViewById(R.id.meal_name);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String position = list.get(getAdapterPosition()).getStrCategory();
                    Toast.makeText(itemView.getContext(), "image is selected", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(itemView.getContext(), CategoryActivity.class);
                    intent.putExtra("Key_ID",position);
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}

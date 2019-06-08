package com.example.recipe.Json.CategoryJson;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recipe.Activity.DetailActivity;
import com.example.recipe.Json.DetailRecipe.DetailRecipe;
import com.example.recipe.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.Cat_VH> {

    List<CategoryFragment> food_item;


    public CategoryRecyclerAdapter(List<CategoryFragment> food_item) {
        this.food_item = food_item;
    }

    @NonNull
    @Override
    public Cat_VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.category_list_items,viewGroup,false);
    return new Cat_VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Cat_VH cat_vh, int i) {

        CategoryFragment  categoryFragment =  food_item.get(i);
        cat_vh.dish_title.setText(categoryFragment.getStrMeal());


        Picasso.with(cat_vh.dish_title.getContext()).load(food_item.get(i).getStrMealThumb())
                .into(cat_vh.dish_img);
    }

    @Override
    public int getItemCount() {
        return food_item.size();
    }

    class Cat_VH extends RecyclerView.ViewHolder{
        ImageView des_img,dish_img;
        TextView des_title,dish_title;
        public Cat_VH(@NonNull final View itemView) {
            super(itemView);

            des_img= (ImageView)itemView.findViewById(R.id.des_img);
            dish_img= (ImageView)itemView.findViewById(R.id.dish_img);
            des_title=(TextView) itemView.findViewById(R.id.des_title);
            dish_title=(TextView)itemView.findViewById(R.id.dish_title);

            dish_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String dishPosition = food_item.get(getAdapterPosition()).getIdMeal();

                    Toast.makeText(itemView.getContext(), dishPosition, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);

                    intent.putExtra("EXTRA_SESSION_ID",dishPosition);

                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}

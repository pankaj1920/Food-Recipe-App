package com.example.recipe.Json.DetailRecipe;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipe.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailRecyclerAdapter extends RecyclerView.Adapter<DetailRecyclerAdapter.Detail_VH> {

    List<DetailRecipe> detailRecipes;

    public DetailRecyclerAdapter(List<DetailRecipe> detailRecipes) {
        this.detailRecipes = detailRecipes;
    }

    @NonNull
    @Override
    public Detail_VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.detail_recipe_itemlist,viewGroup,false);
        return new Detail_VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Detail_VH detail_vh, int i) {

        final DetailRecipe recipe = detailRecipes.get(i);
        detail_vh.Category_name.setText(recipe.getStrCategory());
        detail_vh.Country_name.setText(recipe.getStrArea());
        detail_vh.intruction.setText(recipe.getStrInstructions());

        //adding Ingrident List Dynamically
        //This 1st one will not come bcz we have already set this in above line
        if (!recipe.getStrIngredient1().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient1());
        }
        if (!recipe.getStrIngredient2().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient2());
        }
        if (!recipe.getStrIngredient3().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient3());
        }
        if (!recipe.getStrIngredient4().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient4());
        }
        if (!recipe.getStrIngredient5().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient5());
        }
        if (!recipe.getStrIngredient6().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient6());
        }
        if (!recipe.getStrIngredient7().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient7());
        }
        if (!recipe.getStrIngredient8().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient8());
        }
        if (!recipe.getStrIngredient9().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient9());
        }
        if (!recipe.getStrIngredient10().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient10());
        }
        if (!recipe.getStrIngredient11().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient11());
        }
        if (!recipe.getStrIngredient12().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient12());
        }
        if (!recipe.getStrIngredient13().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient13());
        }
        if (!recipe.getStrIngredient14().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient14());
        }
        if (!recipe.getStrIngredient15().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient15());
        }
        if (!recipe.getStrIngredient16().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient16());
        }
        if (!recipe.getStrIngredient17().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient17());
        }if (!recipe.getStrIngredient18().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient18());
        }if (!recipe.getStrIngredient19().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient19());
        }if (!recipe.getStrIngredient20().isEmpty()){
            detail_vh.ingrident_name.append("\n \u2022 " + recipe.getStrIngredient20());
        }

        //Adding Ingredent Quanity Dynamically
        if (!recipe.getStrMeasure1().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure1().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure1());
        }
        if (!recipe.getStrMeasure2().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure2().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure2());
        }
        if (!recipe.getStrMeasure3().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure3().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure3());
        }
        if (!recipe.getStrMeasure4().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure4().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure4());
        }
        if (!recipe.getStrMeasure5().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure5().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure5());
        }
        if (!recipe.getStrMeasure6().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure6().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure6());
        }
        if (!recipe.getStrMeasure7().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure7().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure7());
        }
        if (!recipe.getStrMeasure8().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure8().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure8());
        }
        if (!recipe.getStrMeasure9().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure9().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure9());
        }
        if (!recipe.getStrMeasure10().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure10().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure10());
        }
        if (!recipe.getStrMeasure11().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure11().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure11());
        }
        if (!recipe.getStrMeasure12().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure12().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure12());
        }
        if (!recipe.getStrMeasure13().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure13().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure13());
        }
        if (!recipe.getStrMeasure14().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure14().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure14());
        }
        if (!recipe.getStrMeasure15().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure15().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure15());
        }
        if (!recipe.getStrMeasure16().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure16().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure16());
        }
        if (!recipe.getStrMeasure17().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure17().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure17());
        }
        if (!recipe.getStrMeasure18().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure18().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure18());
        }
        if (!recipe.getStrMeasure19().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure19().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure19());
        }
        if (!recipe.getStrMeasure20().isEmpty() && !Character.isWhitespace(recipe.getStrMeasure20().charAt(0))) {
            detail_vh.ingridentQuanity.append("\n : " + recipe.getStrMeasure20());
        }






        detail_vh.youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String url = recipe.getStrSource();
                intent.putExtra(Intent.EXTRA_SUBJECT,"abc");
                intent.putExtra(Intent.EXTRA_TEXT,url);

                v.getContext().startActivity(intent);
            }
        });

        detail_vh.source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String url = recipe.getStrYoutube();
                intent.putExtra(Intent.EXTRA_SUBJECT,"abc");
                intent.putExtra(Intent.EXTRA_TEXT,url);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return detailRecipes.size();
    }

    class Detail_VH extends RecyclerView.ViewHolder{
        TextView Category_name,Country_name,intruction,ingridentQuanity,youtube,source,ingrident_name;
        ImageView image_logo;
        public Detail_VH(@NonNull View itemView) {
            super(itemView);

            Category_name = (TextView)itemView.findViewById(R.id.Category_name);
            Country_name = (TextView)itemView.findViewById(R.id.Country_name);
            intruction = (TextView)itemView.findViewById(R.id.intruction);
            ingridentQuanity=(TextView)itemView.findViewById(R.id.ingridentQuanity);
            ingrident_name=(TextView)itemView.findViewById(R.id.ingrident_name);
            youtube = (TextView)itemView.findViewById(R.id.youtube);
            source = (TextView)itemView.findViewById(R.id.source);
            image_logo = (ImageView)itemView.findViewById(R.id.image_logo);
        }
    }
}

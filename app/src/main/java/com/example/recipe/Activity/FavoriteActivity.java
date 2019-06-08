package com.example.recipe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.recipe.R;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        Toolbar fav_toolbar = findViewById(R.id.fav_toolbar);
        setSupportActionBar(fav_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

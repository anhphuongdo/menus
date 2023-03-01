package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tv = findViewById(R.id.textView);
        Intent intent = getIntent();
        String favorites = intent.getStringExtra("Favorites");

        Intent intent1 = getIntent();
        String settings = intent1.getStringExtra("Settings");

        Intent intent2 = getIntent();
        String favorite_type1 = intent.getStringExtra("Favorites-type1");

        Intent intent3 = getIntent();
        String favorite_type2 = intent.getStringExtra("Favorites-type2");

        if(favorites == null){
            favorites = "";
        }
        if(settings == null){
            settings = "";
        }
        if(favorite_type1 == null){
            favorite_type1 = "";
        }
        if(favorite_type2 == null){
            favorite_type2 = "";
        }
        tv.setText(settings + favorites + favorite_type1 + favorite_type2);

    }
}
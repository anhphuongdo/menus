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

        if(favorites == null){
            favorites = "";
        }
        if(settings == null){
            settings = "";
        }
        tv.setText(settings + favorites);

    }
}
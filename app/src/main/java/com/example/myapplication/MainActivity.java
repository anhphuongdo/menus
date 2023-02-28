package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.option_settings:
                showSettings();
                return true;
            case R.id.option_favorites:
                showFavorites();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showFavorites() {
        Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
        intent.putExtra("Favorites", "Đây là trang favorites - optionmenu");
        startActivity(intent);
    }

    private void showSettings() {
        Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
        intent.putExtra("Settings", "Đây là trang settings - optionmenu");
        startActivity(intent);
    }
}
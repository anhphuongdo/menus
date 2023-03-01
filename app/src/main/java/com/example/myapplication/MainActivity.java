package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ImageButton btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_longpress);
        registerForContextMenu(btn);

        btnPopup = findViewById(R.id.btn_popup);
        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(MainActivity.this, btnPopup);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.option_favorites:
                                showFavorites();
                                return true;
                            case R.id.option_settings:
                                showSettings();
                                return true;
                            default: return false;
                        }
                    }
                });
                popup.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
        intent.putExtra("Favorites", "Đây là trang favorites");
        startActivity(intent);
    }

    private void showSettings() {
        Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
        intent.putExtra("Settings", "Đây là trang settings");
        startActivity(intent);
    }

    //menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);

    }

    public void onCreateContextMenu_2(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        MenuItem menuItemStorage = menu.add(1, 1, 1, "Settings");
        menuItemStorage.setIcon(R.drawable.ic_setting_books);

        SubMenu subMenuFavorite = menu.addSubMenu(2, 2, 2, "Favorite books");
        subMenuFavorite.setIcon(R.drawable.ic_favorite_books);

        subMenuFavorite.add(3, 21, 1, "Type 1");
        subMenuFavorite.add(4, 32, 2, "Type 2");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.book_setting:
                showSettings();
                return true;
            case R.id.book_favorite:
                return true;
            case R.id.fb_type1:
                showFbType1();
                return true;
            case R.id.fb_type2:
                showFbType2();
                return true;
            default: return super.onContextItemSelected(item);
        }
    }

    private void showFbType1() {
        Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
        intent.putExtra("Favorites-type1", "Đây là trang favorites type 1");
        startActivity(intent);
    }

    private void showFbType2() {
        Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
        intent.putExtra("Favorites-type2", "Đây là trang favorites type 2");
        startActivity(intent);
    }
}
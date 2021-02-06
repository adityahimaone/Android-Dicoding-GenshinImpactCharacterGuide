package com.example.genshinimpactcharacterguide;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ItemDetails extends AppCompatActivity {
    private ArrayList<Character> listCharacter;
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_DETAIL = "extra_detail";
    public static final String EXTRA_ELEMENT = "extra_element";
    public static final String EXTRA_WEAPON = "extra_weapon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        TextView name = findViewById(R.id.name_received);
        ImageView photo = findViewById(R.id.photo_received);
        TextView detail = findViewById(R.id.detail_received);
        TextView element = findViewById(R.id.element_received);
        TextView weapon = findViewById(R.id.weapon_received);

        String Name = getIntent().getStringExtra(EXTRA_NAME);
        int img = getIntent().getIntExtra(EXTRA_IMAGE, 0);
        String Detail = getIntent().getStringExtra(EXTRA_DETAIL);
        String Element = getIntent().getStringExtra(EXTRA_ELEMENT);
        String Weapon = getIntent().getStringExtra(EXTRA_WEAPON);

        name.setText(Name);
        photo.setImageResource(img);
        detail.setText(Detail);
        element.setText(Element);
        weapon.setText(Weapon);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int selectedMode) {
        switch (selectedMode) {

        }
    }

}

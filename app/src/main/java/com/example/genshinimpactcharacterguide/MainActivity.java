package com.example.genshinimpactcharacterguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCharacter;
    private ArrayList<Character> list = new ArrayList<>();
    private String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setActionBarTitle(title);
        rvCharacter = findViewById(R.id.rv_character);
        rvCharacter.setHasFixedSize(true);

        list.addAll(CharacterData.getListData());
        showRecyclerList();

    }

    private void showRecyclerList(){
        rvCharacter.setLayoutManager(new LinearLayoutManager(this));
        ListCharacterAdapter listCharacterAdapter = new ListCharacterAdapter(list);
        rvCharacter.setAdapter(listCharacterAdapter);

        listCharacterAdapter.setOnItemClickCallback(new ListCharacterAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Character data) {
                showSelectedCharacter(data);
            }
        });
    }


    private void showRecyclerGrid(){
        rvCharacter.setLayoutManager(new GridLayoutManager(this,2));
        GridCharacterAdapter gridCharacterAdapter = new GridCharacterAdapter(list);
        rvCharacter.setAdapter(gridCharacterAdapter);

        gridCharacterAdapter.setOnItemClickCallback(new GridCharacterAdapter.OnItemClickCallback(){
            @Override
            public void onItemClicked(Character data) {
                showSelectedCharacter(data);
            }
        });
    }

    private void showSelectedCharacter(Character character){
        Intent moveIntentWithData = new Intent(MainActivity.this, ItemDetails.class);
        moveIntentWithData.putExtra(ItemDetails.EXTRA_NAME, character.getName());
        moveIntentWithData.putExtra(ItemDetails.EXTRA_IMAGE, character.getPhoto());
        moveIntentWithData.putExtra(ItemDetails.EXTRA_DETAIL, character.getDetail());
        moveIntentWithData.putExtra(ItemDetails.EXTRA_ELEMENT, character.getElement());
        moveIntentWithData.putExtra(ItemDetails.EXTRA_WEAPON, character.getWeapon());
        startActivity(moveIntentWithData);
    }

    private void showRecyclerCardView(){
        rvCharacter.setLayoutManager(new LinearLayoutManager(this));
        CardViewCharacterAdapter cardViewHeroAdapter = new CardViewCharacterAdapter(list);
        rvCharacter.setAdapter(cardViewHeroAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "List Mode";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title = "Grid Mode";
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                title ="Card View Mode";
                showRecyclerCardView();
                break;
            case R.id.action_about:
                Intent moveIntent = new Intent(MainActivity.this, About.class);
                startActivity(moveIntent);
                break;
        }
        setActionBarTitle(title);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }


}
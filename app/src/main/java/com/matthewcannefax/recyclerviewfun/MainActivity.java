package com.matthewcannefax.recyclerviewfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Animal> animalList;
    private EditText etSearch;
    private RecyclerView rvRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch = findViewById(R.id.etSearch);
        rvRecycler = findViewById(R.id.rvRecycler);

        animalList = new ArrayList<>();

        animalList.add(new Animal("Cheetah", Animal.Kingdom.MAMMAL, "meow"));
        animalList.add(new Animal("Elephant", Animal.Kingdom.MAMMAL, "toot"));
        animalList.add(new Animal("Hyacinth Macaw", Animal.Kingdom.BIRD, "squawk"));
        animalList.add(new Animal("Ostrich", Animal.Kingdom.BIRD, "honk"));
        animalList.add(new Animal("Crow", Animal.Kingdom.BIRD, "kaa"));
        animalList.add(new Animal("Crocodile", Animal.Kingdom.REPTILE, "grrr"));
        animalList.add(new Animal("Komodo Dragon", Animal.Kingdom.REPTILE, "hiss"));
        animalList.add(new Animal("Goat", Animal.Kingdom.MAMMAL, "hello"));

        Animal.Kingdom firstKingdom = animalList.get(0).getKingdom();
        for(Animal animal : animalList){
            animal.setActive(animal.getKingdom() == firstKingdom);
        }

        setRVAdapter();

    }

    private void clickKingdom(int position){
        Animal.Kingdom selectedKingdom = Animal.Kingdom.getKingdomByPosition(position);
        for(Animal animal : animalList){
            animal.setActive(animal.getKingdom() == selectedKingdom);
        }
        setRVAdapter();
    }

    private void setRVAdapter(){
        AnimalListAdapter adapter = new AnimalListAdapter(this, animalList, this::clickKingdom);
        rvRecycler.setAdapter(adapter);
        rvRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
package com.matthewcannefax.recyclerviewfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText etSearch;
    private RecyclerView rvRecycler;
    private BaseViewModel viewModel;
    List<Object> objects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch = findViewById(R.id.etSearch);
        rvRecycler = findViewById(R.id.rvRecycler);
        viewModel = new BaseViewModel();

         viewModel.setAnimalList(new ArrayList<>());

        viewModel.getAnimalList().add(new Animal("Cheetah", Animal.Kingdom.MAMMAL, "meow"));
        viewModel.getAnimalList().add(new Animal("Elephant", Animal.Kingdom.MAMMAL, "toot"));
        viewModel.getAnimalList().add(new Animal("Hyacinth Macaw", Animal.Kingdom.BIRD, "squawk"));
        viewModel.getAnimalList().add(new Animal("Ostrich", Animal.Kingdom.BIRD, "honk"));
        viewModel.getAnimalList().add(new Animal("Crow", Animal.Kingdom.BIRD, "kaa"));
        viewModel.getAnimalList().add(new Animal("Crocodile", Animal.Kingdom.REPTILE, "grrr"));
        viewModel.getAnimalList().add(new Animal("Komodo Dragon", Animal.Kingdom.REPTILE, "hiss"));
        viewModel.getAnimalList().add(new Animal("Goat", Animal.Kingdom.MAMMAL, "hello"));

        viewModel.setCarList(new ArrayList<>());

        viewModel.getCarList().add(new Car("CHEVY", "TRAVERSE", "2010", 100000L));
        viewModel.getCarList().add(new Car("HYUNDAI", "SONATA", "2010", 230000L));
        viewModel.getCarList().add(new Car("CHEVY", "CHEYENNE 10", "1971", 20000L));

        Animal.Kingdom firstKingdom = viewModel.getAnimalList().get(0).getKingdom();
        for(Animal animal : viewModel.getAnimalList()){
            animal.setActive(animal.getKingdom() == firstKingdom);
        }

        Collections.sort(viewModel.getAnimalList(), (o1, o2) ->
                o1.getKingdom().compareTo(o2.getKingdom()));

        viewModel.getAnimalList().get(0).setFirst(true);
        Animal.Kingdom previousKingdom = viewModel.getAnimalList().get(0).getKingdom();
        Animal.Kingdom currentKingdom;
        for (int i = 1; i < viewModel.getAnimalList().size(); i++) {
            currentKingdom = viewModel.getAnimalList().get(i).getKingdom();
            if (currentKingdom != previousKingdom) {
                viewModel.getAnimalList().get(i).setFirst(true);
            }
            previousKingdom = currentKingdom;
        }


        objects = viewModel.getAllObjectsList();

        setRVAdapter();

    }

    private void clickKingdom(int position){
        Animal.Kingdom selectedKingdom = Animal.Kingdom.getKingdomByPosition(position);
        for(Animal animal : viewModel.getAnimalList()){
            animal.setActive(animal.getKingdom() == selectedKingdom);
        }
        setRVAdapter();
    }

    private void setRVAdapter(){
//        AnimalListAdapter adapter = new AnimalListAdapter(this, viewModel.getAnimalList(), this::clickKingdom);
//        rvRecycler.setAdapter(adapter);

        ListRowAdapter adapter = new ListRowAdapter(objects, this::clickKingdom);
        rvRecycler.setAdapter(adapter);
        rvRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
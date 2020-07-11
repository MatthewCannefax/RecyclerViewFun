package com.matthewcannefax.recyclerviewfun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

    private List<Animal> animalList;
    private LayoutInflater mInflater;
    private KingdomClick kingdomClick;

    public AnimalListAdapter(Context context,List<Animal> animalList, KingdomClick kingdomClick){
        mInflater = LayoutInflater.from(context);
        this.kingdomClick = kingdomClick;
        this.animalList = animalList;
        Collections.sort(animalList, (o1, o2) ->
                o1.getKingdom().compareTo(o2.getKingdom()));

        animalList.get(0).setFirst(true);
        Animal.Kingdom previousKingdom = animalList.get(0).getKingdom();
        Animal.Kingdom currentKingdom;
        for (int i = 1; i < animalList.size(); i++){
            currentKingdom = animalList.get(i).getKingdom();
            if(currentKingdom != previousKingdom){
                animalList.get(i).setFirst(true);
            }
            previousKingdom = currentKingdom;
        }
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mItemView = mInflater.inflate(R.layout.list_item_animal, parent, false);

        return new AnimalViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animalList.get(position);
        holder.tvKingdom.setText(animal.getKingdom().toString());
        holder.tvName.setText(animal.getName());
        holder.tvSound.setText(animal.getSound());

        if(animalList.get(position).isFirst()){
            holder.kingdomLayout.setVisibility(View.VISIBLE);
        }
        if(animalList.get(position).isActive()){
            holder.contentLayout.setVisibility(View.VISIBLE);
        }else {
            holder.contentLayout.setVisibility(View.GONE);
        }
        holder.kingdomLayout.setOnClickListener(view -> kingdomClick.clickKingdom(animalList.get(position).getKingdom().getPosition()));
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    @Override
    public void onViewRecycled(@NonNull AnimalViewHolder holder) {
        super.onViewRecycled(holder);
    }
}

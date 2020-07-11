package com.matthewcannefax.recyclerviewfun;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.matthewcannefax.recyclerviewfun.ListRow.ANIMAL_ROW;
import static com.matthewcannefax.recyclerviewfun.ListRow.CAR_ROW;

public class ListRowAdapter extends RecyclerView.Adapter<ListRowViewHolder> {

    private List<ListRow> rowList;
    KingdomClick kingdomClick;

    ListRowAdapter(List<Object> objects, KingdomClick kingdomClick) {

        this.kingdomClick = kingdomClick;

        rowList = new ArrayList<>();

        for (Object o :
                objects) {
            if (o instanceof Animal) {
               rowList.add(new AnimalRow((Animal) o));
            } else {
                rowList.add(new CarRow((Car) o));
            }
        }
    }

    @NonNull
    @Override
    public ListRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            default:
                return null;
            case ANIMAL_ROW:
                return new AnimalRowViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_animal, parent, false), kingdomClick);
            case CAR_ROW:
                return new CarRowViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_car, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ListRowViewHolder holder, int position) {
        holder.bind(rowList.get(position));
    }

    @Override
    public int getItemCount() {
        return rowList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return rowList.get(position).getRowType();
    }
}

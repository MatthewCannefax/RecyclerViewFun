package com.matthewcannefax.recyclerviewfun;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

abstract class ListRowViewHolder extends RecyclerView.ViewHolder {
    public ListRowViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(ListRow item){}
}

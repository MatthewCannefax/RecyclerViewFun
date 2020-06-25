package com.matthewcannefax.recyclerviewfun;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder{
    LinearLayout kingdomLayout;
    LinearLayout contentLayout;
    TextView tvKingdom;
    TextView tvName;
    TextView tvSound;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        kingdomLayout = itemView.findViewById(R.id.kingdomLayout);
        contentLayout = itemView.findViewById(R.id.contentLayout);
        tvKingdom = itemView.findViewById(R.id.tvKingdom);
        tvName = itemView.findViewById(R.id.tvName);
        tvSound = itemView.findViewById(R.id.tvSound);
    }
}

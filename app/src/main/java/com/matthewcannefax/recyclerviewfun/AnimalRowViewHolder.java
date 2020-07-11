package com.matthewcannefax.recyclerviewfun;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class AnimalRowViewHolder extends ListRowViewHolder {

    LinearLayout kingdomLayout;
    LinearLayout contentLayout;
    TextView tvKingdom;
    TextView tvName;
    TextView tvSound;
    KingdomClick kingdomClick;

    public AnimalRowViewHolder(@NonNull View itemView, KingdomClick kingdomClick) {
        super(itemView);

        this.kingdomClick = kingdomClick;
        kingdomLayout = itemView.findViewById(R.id.kingdomLayout);
        contentLayout = itemView.findViewById(R.id.contentLayout);
        tvKingdom = itemView.findViewById(R.id.tvKingdom);
        tvName = itemView.findViewById(R.id.tvName);
        tvSound = itemView.findViewById(R.id.tvSound);
    }

    @Override
    public void bind(ListRow item) {
        bind((AnimalRow) item);
    }

    private void bind(AnimalRow item) {
        kingdomLayout.setVisibility(item.isFirst() ? View.VISIBLE : View.GONE);
        kingdomLayout.setOnClickListener(view -> kingdomClick.clickKingdom(item.getKingdom().getPosition()));
        contentLayout.setVisibility(item.isActive() ? View.VISIBLE : View.GONE);
        tvKingdom.setText(item.getKingdom().getName());
        tvName.setText(item.getName());
        tvSound.setText(item.getSound());
    }
}

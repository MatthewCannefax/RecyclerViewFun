package com.matthewcannefax.recyclerviewfun;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

public class CarRowViewHolder extends ListRowViewHolder {

    private TextView makeAndModel;
    private TextView year;
    private TextView miles;

    public CarRowViewHolder(@NonNull View itemView) {
        super(itemView);

        makeAndModel = itemView.findViewById(R.id.make_and_model_textview);
        year = itemView.findViewById(R.id.year_textview);
        miles = itemView.findViewById(R.id.miles_textview);
    }

    @Override
    public void bind(ListRow item) {
        bind((CarRow) item);
    }

    private void bind(CarRow item) {
        makeAndModel.setText(item.getMakeAndModel());
        year.setText(item.getYear());
        miles.setText(item.getMiles());
    }
}

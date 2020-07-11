package com.matthewcannefax.recyclerviewfun;

public class CarRow extends ListRow{

    private String makeAndModel;
    private String year;
    private String miles;

    public String getMakeAndModel() {
        return makeAndModel;
    }

    public String getYear() {
        return year;
    }

    public String getMiles() {
        return miles;
    }

    CarRow(Car car){
        setRowType(CAR_ROW);

        makeAndModel = String.format("%s %s", car.getMake(), car.getModel());
        year = car.getYear();
        miles = Long.toString(car.getMiles());
    }
}

package com.matthewcannefax.recyclerviewfun;

abstract class ListRow {

    private int rowType;

    public static final int ANIMAL_ROW = 1;
    public static final int CAR_ROW = 2;

    public void setRowType(int rowType) {
        this.rowType = rowType;
    }

    public int getRowType(){
        return rowType;
    }

}

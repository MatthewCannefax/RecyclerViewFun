package com.matthewcannefax.recyclerviewfun;

import java.util.ArrayList;
import java.util.List;

public class BaseViewModel {

    private List<Animal> animalList;
    private List<Car> carList;

    private List<Object> allObjects;

    public List<Object> getAllObjectsList() {
        if (allObjects == null) {
            allObjects = new ArrayList<>();
            if (animalList != null) {
                allObjects.addAll(animalList);
            }
            if (carList != null) {
                allObjects.addAll(carList);
            }
        }

        return allObjects;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }
}

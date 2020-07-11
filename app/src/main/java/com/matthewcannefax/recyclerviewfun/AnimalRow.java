package com.matthewcannefax.recyclerviewfun;

public class AnimalRow extends ListRow{

    private String name;
    private Animal.Kingdom kingdom;
    private String sound;
    private boolean first;
    private boolean active;

    public AnimalRow(Animal animal){
        setRowType(ANIMAL_ROW);

        name = animal.getName();
        kingdom = animal.getKingdom();
        sound = animal.getSound();
        first = animal.isFirst();
        active = animal.isActive();
    }

    public String getName() {
        return name;
    }

    public Animal.Kingdom getKingdom() {
        return kingdom;
    }

    public String getSound() {
        return sound;
    }

    public boolean isFirst() {
        return first;
    }

    public boolean isActive() {
        return active;
    }


}

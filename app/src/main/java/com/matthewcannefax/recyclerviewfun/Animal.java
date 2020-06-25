package com.matthewcannefax.recyclerviewfun;

import java.util.Objects;

public class Animal {

    enum Kingdom{
        MAMMAL(0, "Mammal"),
        REPTILE(1, "Reptile"),
        BIRD(2, "Bird");

        private int position;
        private String name;

        Kingdom(int position, String name){
            this.position = position;
            this.name = name;
        }

        public int getPosition() {
            return position;
        }

        public String getName() {
            return name;
        }

        public static Kingdom getKingdomByPosition(int pos) {
            for(Animal.Kingdom kingdom : Animal.Kingdom.values()){
                if (kingdom.getPosition() == pos){
                    return kingdom;
                }
            }
            return MAMMAL;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public Animal(String name, Kingdom kingdom, String sound){
        this.name = name;
        this.kingdom = kingdom;
        this.sound = sound;
    }

    private String name;
    private Kingdom kingdom;
    private String sound;
    private boolean first = false;
    private boolean active = true;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Kingdom getKingdom() {
        return kingdom;
    }

    public void setKingdom(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return kingdom == animal.kingdom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kingdom);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

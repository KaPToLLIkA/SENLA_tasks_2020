package com.tasks.task_6;

import java.util.ArrayList;

class Cargo {
    private ArrayList<Item> items = new ArrayList<>();

    public Cargo(Cargo oldCargo) {
        this.items = new ArrayList<>(oldCargo.items);
    }

    public Cargo() {}

    public Item getItem(int index) {
        return items.get(index);
    }

    public void addItem(Item newItem) {
        items.add(newItem);
    }

    public int getSize() {
        return items.size();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}

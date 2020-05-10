package com.tasks.task_6;

class Item {
    private double weight;
    private double cost;

    Item(double weight, double cost) {
        this.cost = cost;
        this.weight = weight;
    }

    double getWeight() {
        return weight;
    }

    double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "\n{weight: " + weight + "; cost: " + cost + "}";
    }
}

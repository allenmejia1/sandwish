package com.pluralsight;

public class Drinks {
    private DrinkType type;
    private DrinkSize size;

    public Drinks(DrinkType type, DrinkSize size) {
        this.type = type;
        this.size = size;

    }

    public double getPrice() {
        return size.getPrice();
    }

    @Override
    public String toString() {
        return size.getLabel() + " " + type.getName() + " - $" + String.format("%.2f", getPrice());
    }
}

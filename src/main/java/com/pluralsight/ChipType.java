package com.pluralsight;

public enum ChipType {

    BBQ("BBQ", 2.00),
    SOUR_CREAM("Sour Cream", 2.00),
    LAYS("LAYS", 2.00),
    CHEETOS("Cheetos", 2.00);

    private final String name;
    private final double price;

    ChipType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", price);
    }
}




package com.pluralsight;

public enum DrinkSize {
    SMALL("SMALL", 1.50),
    MEDIUM("MEDIUM", 2.00),
    LARGE("LARGE", 2.50);

    private final String label;
    private final double price;


    DrinkSize(String label, double price) {
        this.label = label;
        this.price = price;
    }
    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return label + " - $" + String.format("%.2f", price);
    }
}
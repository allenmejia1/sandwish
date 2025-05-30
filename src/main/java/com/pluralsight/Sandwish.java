package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwish {
    private SandwishSize size;
    private BreadType bread;
    private List<ToppingsMenu> toppings;
    private boolean isToasted;

    public Sandwish( SandwishSize size, BreadType bread, boolean isToasted) {
        this.size = size;
        this.bread = bread;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();

    }

    public void addTopping(ToppingsMenu topping) {
        toppings.add(topping);
    }

    @Override
    public String toString() {
        StringBuilder toppingsStr = new StringBuilder();
        for (ToppingsMenu topping : toppings) {
            toppingsStr.append("\n    - ").append(topping.toString());
        }
        return "Sandwish [size:" + size +
                ", bread:" + bread +
                ", toppings:" + toppingsStr.toString() +
                "\n, price=$" + String.format("%.2f", getPrice()) + "]";
    }



    public double getPrice() {
        double basePrice = 0.0;

        switch (size) {
            case FOUR_INCH:
                basePrice = 4.50;
                break;
            case EIGHT_INCH:
                basePrice = 6.00;
                break;
            case TWELVE_INCH:
                basePrice = 8.50;
                break;
        }

        for (ToppingsMenu t : toppings) {
        }

        return basePrice;
    }


    //Add getters and setters

    public SandwishSize getSize() {
        return size;
    }

    public BreadType getBread() {
        return bread;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public List<ToppingsMenu> getToppings() {
        return toppings;
    }

}

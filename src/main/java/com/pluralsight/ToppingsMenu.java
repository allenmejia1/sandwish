package com.pluralsight;

public class ToppingsMenu {
    private String name;
    private ToppingType toppingType;
    private boolean isExtra;
    private SandwishSize size;


    //Create Constructor
    public ToppingsMenu(String name, ToppingType toppingType, boolean isExtra, SandwishSize size) {
        this.name = name;
        this.toppingType = toppingType;
        this.isExtra = isExtra;
        this.size = size;

    }

    //Create getters and setters

    public String getName() {
        return name;
    }

    public ToppingType getToppingType() {
        return toppingType;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public SandwishSize getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToppingType(ToppingType toppingType) {
        this.toppingType = toppingType;
    }

    public void setExtra(boolean isExtra) {
        this.isExtra = isExtra;
    }

    public void setSize(SandwishSize size) {
        this.size = size;
    }

    @Override
    public String toString() {
        String extraText = isExtra ? " (Extra)" : "";
        return name + extraText + " [" + toppingType + "]";
    }



}

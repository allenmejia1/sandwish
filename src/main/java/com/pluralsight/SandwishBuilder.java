package com.pluralsight;

public class SandwishBuilder {

    private SandwishSize size;
    private BreadType bread;
    private boolean toasted;
    private Sandwish sandwish;

    public SandwishBuilder setSize(SandwishSize size) {
        this.size = size;
        return this;
    }

    public SandwishBuilder setBread(BreadType bread) {
        this.bread = bread;
        return this;
    }

    public SandwishBuilder setToasted(boolean toasted) {
        this.toasted = toasted;
        return this;
    }

    public SandwishBuilder addTopping(String name, ToppingType type, boolean isExtra) {
        if (sandwish == null) {
            sandwish = new Sandwish(size, bread, toasted);
        }

        ToppingsMenu topping = new ToppingsMenu(name, type, isExtra, size);
        sandwish.addTopping(topping);
        return this;
    }

    public Sandwish build() {
        if (sandwish == null) {
            sandwish = new Sandwish( size, bread, toasted);
        }

        return sandwish;
    }



}

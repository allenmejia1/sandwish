package com.pluralsight;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwish> sandwiches = new ArrayList<>();
    private List<Drinks> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwish sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drinks drink) {
        drinks.add(drink);
    }

    public void addChips(ChipType chipType) {
        chips.add(new Chips(chipType.getName(), chipType.getPrice()));

    }

    public List<Sandwish> getSandwiches() {
        return sandwiches;
    }

    public List<Drinks> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Sandwish s : sandwiches) {
            total += s.getPrice();
        }

        //Give an example price for the drinks and chips
        total += drinks.size() * 2.50;
        total += chips.size() * 2.00;
        return total;

    }

    public void clear() {
        sandwiches.clear();
        drinks.clear();
        chips.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Sandwiches:\n");
        if (sandwiches.isEmpty()) {
            sb.append("  (none)\n");
        } else {
            for (Sandwish s : sandwiches) {
                sb.append("  - ").append(s).append("\n");
            }
        }

        sb.append("Drinks:\n");
        if (drinks.isEmpty()) {
            sb.append("  (none)\n");
        } else {
            for (Drinks d : drinks) {
                sb.append("  - ").append(d).append("\n");
            }
        }

        sb.append("Chips:\n");
        if (chips.isEmpty()) {
            sb.append("  (none)\n");
        } else {
            for (Chips c : chips) {
                sb.append("  - ").append(c).append("\n");
            }
        }

        sb.append(String.format("Total Price: $%.2f\n", getTotalPrice()));

        return sb.toString();
    }
}

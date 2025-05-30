package com.pluralsight;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Toppings {
    public static final List<String> MEATS = Arrays.asList("steak", "bacon", "ham", "salami","chicken", "turkey" );
    public static final List<String> CHEESES = Arrays.asList("american", " provolone", "cheddar", "swiss");
    public static final List<String> REGULARS = Arrays.asList("lettuce","onions", "tomatoes", "cucumbers", "pickles", "avocado");
    private static final List<String> SIDES = Arrays.asList("sauce", "drinks", "chips");
    private static final List<String> SAUCES = Arrays.asList("mayo", "ketchup", "mustard", "ranch", "vinaigrette");

    public static void printAvailableToppings(){
        System.out.println("Meats:" + MEATS);
        System.out.println("Cheeses:" + CHEESES);
        System.out.println("Regular Toppings:" + REGULARS);
        System.out.println("SIDES:" + SIDES);
        System.out.println("SAUCES:" +SAUCES);

    }

    public static boolean isValidTopping(String name) {
        name = name.toLowerCase();

        for (String topping : MEATS)
            if (topping.equals(name))
                return true;

        for (String topping : CHEESES)
            if (topping.equals(name))
                return true;

        for (String topping : REGULARS)
            if (topping.equals(name))
                return true;

        for (String topping : SIDES)
            if (topping.equals(name))
            return true;

        for (String topping : SAUCES)
            if (topping.equals(name))
                return true;

        return false;

    }

    public static ToppingType getToppingTypeByName(String name) {
        name = name.toLowerCase();
        if (MEATS.contains(name)) return ToppingType.MEAT;
        if (CHEESES.contains(name)) return ToppingType.CHEESE;
        if (REGULARS.contains(name)) return ToppingType.REGULAR;
        if (SAUCES.contains(name)) return ToppingType.SAUCE;
        if (SIDES.contains(name)) return ToppingType.SIDE;
        return ToppingType.REGULAR; // fallback
    }
}



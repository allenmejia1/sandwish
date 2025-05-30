package com.pluralsight;

public enum DrinkType {

    Coke("Coke"),
    Dr_Pepper("Dr Pepper"),
    Iced_Tea("Iced Tea"),
    Sprite("Sprite");

    private final String name;

    DrinkType(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public static DrinkType getDrinkTypeByInput(String input) {
        for (DrinkType dt : DrinkType.values()) {
            if (dt.getName().equalsIgnoreCase(input.trim())) {
                return dt;
            }
        }
        return null;
    }



    @Override
    public String toString() {
        return name;
    }
}
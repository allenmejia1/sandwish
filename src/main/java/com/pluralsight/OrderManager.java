package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager {
    public static void startNewOrder(Scanner scanner) {
        List<Sandwish> sandwiches = new ArrayList<>();
        List <String> drinks = new ArrayList<>();
        List <String> chips = new ArrayList<>();

        boolean ordering = true;
        while (ordering) {
            System.out.println("Order Menu:");
            System.out.println("(1) Add Sandwich");
            System.out.println("(2) Add drink");
            System.out.println("(3) Add chips");
            System.out.println("(4) Checkout");
            System.out.println("(0) Cancel Order");

            String option = scanner.nextLine();

            switch (option) {
                case "1":

            }

        }
    }
}

package com.pluralsight;

import com.pluralsight.Receipt;
import com.pluralsight.Order;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Order order = new Order();
        //Receipt.generate(order);

        Order currentOrder = null;

        boolean running = true;
        while (running) {
            System.out.println("Welcome to the SandWISH shop!");
            System.out.println("\n=== Home Screen ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            String homeChoice = scanner.nextLine().trim();

            switch (homeChoice) {
                case "1":
                    currentOrder = new Order();
                    orderScreen(scanner, currentOrder);
                    break;
                case "0":
                    running = false;
                    System.out.println("Thank you for visiting sandWISH shop!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }

    private static void orderScreen(Scanner scanner, Order order) {
        SandwishBuilder builder = new SandwishBuilder();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n=== Order Screen ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");

            String orderChoice = scanner.nextLine().trim();

            switch (orderChoice) {
                case "1":
                    Sandwish sandwich = createSandwich(scanner);
                    if (sandwich != null) {
                        order.addSandwich(sandwich);
                        System.out.println("Sandwich added.");
                    }
                    break;

                case "2":
                    System.out.println("Available drink sizes: SMALL, MEDIUM, LARGE");
                    System.out.print("Enter drink size: ");
                    String sizeInput = scanner.nextLine().trim().toUpperCase();

                    DrinkSize size;
                    try {
                        size = DrinkSize.valueOf(sizeInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid drink size.");
                        break;
                    }

                    System.out.println("Available drink flavors:");
                    for (DrinkType dt : DrinkType.values()) {
                        System.out.println("- " + dt.getName());
                    }

                    System.out.print("Enter drink flavor (e.g., Coke): ");
                    String flavorInput = scanner.nextLine().trim();

                    DrinkType flavor = DrinkType.getDrinkTypeByInput(flavorInput);
                    if (flavor == null) {
                        System.out.println("Invalid drink flavor.");
                        break;
                    }

                    Drinks drink = new Drinks(flavor, size);
                    order.addDrink(drink);
                    System.out.println("Drink added: " + drink);


                    break;

                case "3":
                    System.out.println("Available chip options:");
                    ChipType[] chipOptions = ChipType.values();
                    for (int i = 0; i < chipOptions.length; i++) {
                        System.out.println((i + 1) + ") " + chipOptions[i].getName());
                    }

                    System.out.print("Select chip by number (or 0 to cancel): ");
                    String chipInput = scanner.nextLine().trim();
                    try {
                        int choice = Integer.parseInt(chipInput);
                        if (choice > 0 && choice <= chipOptions.length) {
                            ChipType selectedChip = chipOptions[choice - 1];
                            order.addChips(selectedChip);  // <-- pass ChipType enum here
                            System.out.println("Chips added: " + selectedChip.getName());
                        } else if (choice == 0) {
                            System.out.println("No chips added.");
                        } else {
                            System.out.println("Invalid selection.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;



                case "4":
                    // Checkout
                    System.out.println("\n=== Checkout ===");
                    System.out.println(order);
                    System.out.print("Confirm order? (y/n): ");
                    String confirm = scanner.nextLine().trim().toLowerCase();
                    if (confirm.equals("y")) {
                        Receipt.generate(order);  // <-- Generate the receipt here, after order is complete
                        System.out.println("Order confirmed! Receipt created.");
                        ordering = false; // go back to home screen
                    } else {
                        System.out.println("Checkout cancelled.");
                    }
                    break;



                case "0":
                    order.clear();
                    System.out.println("Order cancelled. Returning to home screen.");
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static Sandwish createSandwich(Scanner scanner) {
        SandwishBuilder builder = new SandwishBuilder();

        // Choose sandwich size
        System.out.println("Choose a sandwich size: 1) Four inch  2) Eight inch  3) Twelve inch");
        int sizeChoice = readIntInRange(scanner, 1, 3);
        SandwishSize size = switch (sizeChoice) {
            case 1 -> SandwishSize.FOUR_INCH;
            case 2 -> SandwishSize.EIGHT_INCH;
            case 3 -> SandwishSize.TWELVE_INCH;
            default -> SandwishSize.EIGHT_INCH;
        };
        builder.setSize(size);

        // Choose bread
        System.out.println("Choose bread: 1) White  2) Wheat  3) Rye  4) Wrap");
        int breadChoice = readIntInRange(scanner, 1, 4);
        BreadType bread = switch (breadChoice) {
            case 1 -> BreadType.WHITE;
            case 2 -> BreadType.WHEAT;
            case 3 -> BreadType.RYE;
            case 4 -> BreadType.WRAP;
            default -> BreadType.WHITE;
        };
        builder.setBread(bread);

        // Toasted?
        System.out.println("Do you want it toasted? (y/n)");
        boolean toasted = readYesNo(scanner);
        builder.setToasted(toasted);

        // Add toppings
        System.out.println("Here are the available toppings!\n");
        Toppings.printAvailableToppings();

        while (true) {
            System.out.println("Enter topping name(s)  (or type 0 to finish):");
            String line = scanner.nextLine().trim();

            if (line.equals("0")) {
                break;
            }

            if (line.isEmpty()) {
                continue;
            }

            String[] toppingNames = line.split(",");
            for (String name : toppingNames) {
                String toppingName = name.trim();
                if (toppingName.isEmpty()) {
                    continue;
                }

                ToppingType type = Toppings.getToppingTypeByName(toppingName);
                System.out.println("Is \"" + toppingName + "\" extra? (y/n)");
                boolean isExtra = readYesNo(scanner);

                builder.addTopping(toppingName, type, isExtra);
            }
        }

        return builder.build();
        

    }




    private static int readIntInRange(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static boolean readYesNo(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println("Please enter 'y' or 'n':");
            }
        }
    }
}

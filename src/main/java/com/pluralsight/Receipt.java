package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private static final String RECEIPT_FOLDER = "receipts";

    public static void generate(Order order) {
        File folder = new File(RECEIPT_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String filename = RECEIPT_FOLDER + File.separator + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            System.out.println("Order string: " + order.toString());  // Debug print
            writer.write("=== Receipt ===\n");
            writer.write(order.toString());
            writer.flush();  // just to be sure
            System.out.println("Receipt saved as: " + filename);
        } catch (IOException e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


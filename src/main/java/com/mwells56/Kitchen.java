package com.mwells56;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kitchen {

    private Scanner userInput = new Scanner(System.in);

    private List<String> kitchenInventory = loadKitchen();

    private List<String> loadKitchen() {
        File kitchenInventoryFile = new File("C:\\Users\\Student\\workspace\\dinner-generator\\src\\main\\resources\\kitchen-inventory.txt");
        List<String> kitchenInventory = new ArrayList<>();
        if (kitchenInventoryFile.exists()) {
            try (Scanner kitchenInventoryFileContents = new Scanner(kitchenInventoryFile)) {
                List<String> inventoryList = new ArrayList<>();
                while (kitchenInventoryFileContents.hasNextLine()) {
                    kitchenInventory.add(kitchenInventoryFileContents.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }
        return kitchenInventory;
    }

    public List<String> getKitchenInventory() {
        return kitchenInventory;
    }

    public void displayKitchen() {
        for (String ingredient : getKitchenInventory()) {
            System.out.println(ingredient);
        }
    }

    public void addToKitchen() {
        File kitchenInventoryFile = new File("C:\\Users\\Student\\workspace\\dinner-generator\\src\\main\\resources\\kitchen-inventory.txt");
        boolean append = kitchenInventoryFile.exists();

        System.out.println("What ingredients would you like to add? (comma separated)");
        String[] ingredientsToAddArray = userInput.nextLine().toLowerCase().replace(", ", ",").split(",");

        try (PrintWriter kitchenWriter = new PrintWriter(new FileOutputStream(kitchenInventoryFile, append))) {
            for (String ingredient : ingredientsToAddArray) {
                kitchenWriter.println(ingredient);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void removeFromKitchen() {

    }
}

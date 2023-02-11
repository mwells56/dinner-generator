package com.mwells56;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kitchen {

    private Scanner userInput = new Scanner(System.in);

    private static List<String> kitchenInventory;

    public void loadKitchen() {
        File kitchenInventoryFile = new File("C:\\Users\\Student\\workspace\\dinner-generator\\src\\main\\resources\\kitchen-inventory.txt");

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
    }

    public static List<String> getKitchenInventory() {
        return kitchenInventory;
    }

    public void displayKitchen() {
        for (String ingredient : kitchenInventory) {
            System.out.println(ingredient);
        }
    }

    public void addToKitchen() {

    }

    public void removeFromKitchen() {

    }
}

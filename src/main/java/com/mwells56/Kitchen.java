package com.mwells56;

import java.util.Scanner;

public class Kitchen {

    private Scanner userInput = new Scanner(System.in);

    public void displayKitchen() {

    }

    public void addToKitchen() {
        // Ask user if they want to add or remove ingredients from the kitchen
        System.out.print("Would you like to add ingredients to your kitchen? (y/n) ");
        String addInventory = userInput.nextLine();

        while (addInventory.equals("y")) {
            System.out.print("What would you like to add? ");
            String newIngredient = userInput.nextLine();
            kitchenInventory.add(newIngredient);
            System.out.print("Would you like to add anything else? (y/n) ");
            addInventory = userInput.nextLine();
        }
    }

    public void removeFromKitchen() {
        System.out.print("Would you like to remove ingredients to your kitchen? (y/n) ");
        String removeInventory = userInput.nextLine();

        while (removeInventory.equals("y")) {
            System.out.print("What would you like to remove? ");
            String newIngredient = userInput.nextLine();
            kitchenInventory.remove(newIngredient);
            System.out.print("Would you like to add anything else? (y/n) ");
            removeInventory = userInput.nextLine();
        }
    }
}

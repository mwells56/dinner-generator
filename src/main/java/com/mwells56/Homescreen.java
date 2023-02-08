package com.mwells56;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Homescreen {
    public static void main(String[] args) {
        Scanner userInput = new Scanner (System.in);
        boolean programRunning = true;

        DinnerGenerator dinnerGenerator = new DinnerGenerator();

        File kitchenInventoryLog = new File("C:\\Users\\Student\\workspace\\dinner-generator\\src\\main\\resources\\kitchen-inventory.txt");

        if (kitchenInventoryLog.exists()) {
            try (Scanner kitchenInventory = new Scanner(kitchenInventoryLog)) {
                List<String> inventoryList = new ArrayList<>();
                while (kitchenInventory.hasNextLine()) {
                    inventoryList.add(kitchenInventory.nextLine());
                }
                dinnerGenerator.setKitchenInventory(inventoryList);
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }

        File cookbook = new File ("C:\\Users\\Student\\workspace\\dinner-generator\\src\\main\\resources\\cookbook.txt");

        if (cookbook.exists()) {
            if (cookbook.exists()) {
                try (Scanner cookbookContents = new Scanner(cookbook)) {
                    Map<String, List<String>> recipeMap = new HashMap<>();
                    while (cookbookContents.hasNextLine()) {
                        String[] recipeArray = (cookbookContents.nextLine()).split(",");
                        String dishName = recipeArray[0];
                        List<String> ingredientsList = new ArrayList<>();
                        for (int i = 1; i < recipeArray.length; i++) {
                            ingredientsList.add(recipeArray[i]);
                        }

                        recipeMap.put(dishName, ingredientsList);
                        dinnerGenerator.setRecipeMap(recipeMap);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                }
            }
        }

        while (programRunning) {
            System.out.println("Please choose from the following options: ");
            System.out.println("(1) Generate a meal idea");
            System.out.println("(2) Add items to the kitchen");
            System.out.println("(3) Remove items from the kitchen");
            System.out.println("(4) Add recipes to the cookbook");
            System.out.println("(5) Exit");

            String option = userInput.nextLine();

            switch (option) {
                case ("1"):
                    dinnerGenerator.generateRecipes();
                    break;
                case ("2"):
                    dinnerGenerator.addToKitchen();
                    break;
                case ("3"):
                    dinnerGenerator.removeFromKitchen();
                    break;
                case ("4"):
                    dinnerGenerator.addToCookbook();
                    break;
                case("5"):
                    System.out.println("Thank you for using the Dinner Generator. Bone apple tea!");
                    programRunning = false;
                    break;
            }
        }
    }
}

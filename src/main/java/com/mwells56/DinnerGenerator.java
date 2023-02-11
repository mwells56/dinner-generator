package com.mwells56;

import java.io.*;
import java.util.*;

public class DinnerGenerator {

    private PrintWriter out;
    private Scanner in;

    private List<Recipe> cookbook;
    private List<String> kitchenInventory;

    private Scanner userInput = new Scanner(System.in);

    public List<Recipe> getCookbook() {
        return cookbook;
    }

    public void setRecipes(List<Recipe> cookbook) {
        this.cookbook = cookbook;
    }

    public List<String> getKitchenInventory() {
        return kitchenInventory;
    }

    public void setKitchenInventory(List<String> kitchenInventory) {
        this.kitchenInventory = kitchenInventory;
    }

    public void loadKitchen() {
        File kitchenInventoryLog = new File("C:\\Users\\Student\\workspace\\dinner-generator\\src\\main\\resources\\kitchen-inventory.txt");

        if (kitchenInventoryLog.exists()) {
            try (Scanner kitchenInventoryFile = new Scanner(kitchenInventoryLog)) {
                List<String> inventoryList = new ArrayList<>();
                while (kitchenInventoryFile.hasNextLine()) {
                    kitchenInventory.add(kitchenInventoryFile.nextLine());
                }
                setKitchenInventory(inventoryList);
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }
    }

    public void loadCookbook() {
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
                        setRecipes(recipes);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                }
            }
        }
    }

    public void generateRecipes() {
        System.out.println("You have the ingredients to make the following recipes:");
        for (Map.Entry<String, List<String>> recipe : recipeMap.entrySet()) {
            if (kitchenInventory.containsAll(recipe.getValue())) {
                System.out.println(recipe.getKey());
            }
        }
    }
}

package com.mwells56;

import java.util.*;

public class DinnerGenerator {
    static Scanner userInput = new Scanner(System.in);

    static Map<String, List<String>> recipeMap = new HashMap<>();
    static List<String> kitchenInventory = new ArrayList<>();



    public DinnerGenerator() {

    }

    public static void setRecipeMap(Map<String, List<String>> recipeMap) {
        DinnerGenerator.recipeMap = recipeMap;
    }

    public static void setKitchenInventory(List<String> kitchenInventory) {
        DinnerGenerator.kitchenInventory = kitchenInventory;
    }

    public static void generateRecipes() {
        System.out.println("You have the ingredients to make the following recipes:");
        for (Map.Entry<String, List<String>> recipe : recipeMap.entrySet()) {
            if (kitchenInventory.containsAll(recipe.getValue())) {
                System.out.println(recipe.getKey());
            }
        }
    }

    public static void addToKitchen() {
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

    public static void removeFromKitchen() {
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

    public static void addToCookbook() {
        // Ask user if there are any new recipes to add
        System.out.print("Would you like to add any recipes? (y/n) ");
        String addRecipe = userInput.nextLine();

        while (addRecipe.equals("y")) {
            // Ask for dish name and ingredients
            System.out.print("What is the name of the dish? ");
            String newDish = userInput.nextLine();

            System.out.print("What ingredients does the new recipe require? (separate by commas) ");
            String[] newDishIngredients = userInput.nextLine().split(", ");

            // Pull ingredients into a list to be used for a new recipe instance
            List<String> recipeIngredients = new ArrayList<>();
            for (String ingredient : newDishIngredients) {
                recipeIngredients.add(ingredient.toLowerCase());
            }
            Recipe addDish = new Recipe (newDish.toLowerCase(), recipeIngredients);

            // Add new recipe to the map
            recipeMap.put(addDish.getDishName(), addDish.getIngredients());
            System.out.print("Would you like to add another recipe? (y/n) ");
            addRecipe = userInput.nextLine();
        }
    }
}

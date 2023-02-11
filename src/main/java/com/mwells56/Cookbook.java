package com.mwells56;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cookbook {

    private Scanner userInput = new Scanner(System.in);

    public void displayCookbook () {

    }

    public void addToCookbook() {
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

    public void removeFromCookbook() {

    }
}

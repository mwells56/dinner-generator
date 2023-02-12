package com.mwells56;

import java.io.*;
import java.util.*;

public class DinnerGenerator {

    private PrintWriter out;
    private Scanner in;

    private Scanner userInput = new Scanner(System.in);

    public void generateRecipes() {
        Cookbook cookbook = new Cookbook();
        Kitchen kitchen = new Kitchen();

        List<Recipe> cookbookList = cookbook.getCookbook();
        List<String> kitchenList = kitchen.getKitchenInventory();

        for (Recipe recipe : cookbookList) {
            List<String> ingredients = recipe.getIngredients();
            if (kitchenList.containsAll(ingredients)) {
                System.out.println("\nYou could make " + recipe.getDishName());

                System.out.println("You need the following ingredients: ");
                for (String ingredient : recipe.getIngredients()) {
                    System.out.println(ingredient);
                }
            }
        }
    }
}

package com.mwells56;

import java.io.*;
import java.util.*;

public class DinnerGenerator {

    private PrintWriter out;
    private Scanner in;

    private Scanner userInput = new Scanner(System.in);

    private Cookbook cookbook = new Cookbook();
    private Kitchen kitchen = new Kitchen();

    public void generateRecipes() {
        for (Recipe recipe : cookbook.getCookbook()) {
            if (kitchen.getKitchenInventory().containsAll(recipe.getIngredients())) {
                System.out.println("You could make " + recipe.getDishName());
                System.out.println("You need the following ingredients: ");
                for (String ingredient : recipe.getIngredients()) {
                    System.out.println(ingredient);
                }
            }
        }
    }
}

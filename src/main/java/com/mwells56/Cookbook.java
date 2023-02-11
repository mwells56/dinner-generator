package com.mwells56;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cookbook {

    private Scanner userInput = new Scanner(System.in);

    private static List<Recipe> cookbook;

    public void loadCookbook() {
        File cookbookFile = new File ("C:\\Users\\Student\\workspace\\dinner-generator\\src\\main\\resources\\cookbook.txt");

        if (cookbookFile.exists()) {
            try (Scanner cookbookFileContents = new Scanner(cookbookFile)) {
                while (cookbookFileContents.hasNextLine()) {
                    String recipeString = cookbookFileContents.nextLine();

                    String[] recipeAndIngredientsArray = recipeString.split("\\|");

                    String dishName = recipeAndIngredientsArray[0];

                    List<String> ingredientsList = new ArrayList<>();
                    String[] ingredientsArray = recipeAndIngredientsArray[1].split(",");
                    for (String ingredient : ingredientsArray) {
                        ingredientsList.add(ingredient);
                    }

                    Recipe recipe = new Recipe(dishName, ingredientsList);
                    cookbook.add(recipe);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }
    }

    public static List<Recipe> getCookbook() {
        return cookbook;
    }

    public void displayCookbook () {
        for (Recipe recipe : cookbook) {
            String dishName = recipe.getDishName();
            String ingredients = String.join(", ", recipe.getIngredients());

            System.out.println("Dish: " + recipe.getDishName());
            System.out.println("Ingredients: " + ingredients + "\n");
        }
    }

    public void addToCookbook() {

    }

    public void removeFromCookbook() {

    }
}

package com.mwells56;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.*;

public class Cookbook {

    private Scanner userInput = new Scanner(System.in);

    private List<Recipe> cookbook = loadCookbook();

    private List<Recipe> loadCookbook() {
        File cookbookFile = new File ("C:\\Users\\Student\\workspace\\dinner-generator\\src\\main\\resources\\cookbook.txt");
        List<Recipe> cookbook = new ArrayList<>();
        if (cookbookFile.exists()) {
            try (Scanner cookbookFileContents = new Scanner(cookbookFile)) {
                while (cookbookFileContents.hasNextLine()) {
                    String recipeString = cookbookFileContents.nextLine();

                    String[] recipeAndIngredientsArray = recipeString.split("\\|");

                    String dishName = recipeAndIngredientsArray[0];

                    String[] ingredientsArray = recipeAndIngredientsArray[1].split(",");
                    List<String> ingredientsList = new ArrayList<>(Arrays.asList(ingredientsArray));

                    Recipe recipe = new Recipe(dishName, ingredientsList);
                    cookbook.add(recipe);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }
        return cookbook;
    }

    public List<Recipe> getCookbook() {
        return cookbook;
    }

    public void displayCookbook () {
        for (Recipe recipe : getCookbook()) {
            String dishName = recipe.getDishName();
            String ingredients = String.join(",", recipe.getIngredients());

            System.out.println("Dish: " + recipe.getDishName());
            System.out.println("Ingredients: " + ingredients + "\n");
        }
    }

    public void addToCookbook() {
        File cookbookFile = new File ("C:\\Users\\Student\\workspace\\dinner-generator\\src\\main\\resources\\cookbook.txt");

        System.out.println("What is the name of the dish you would like to add?");
        String recipeName = userInput.nextLine().toLowerCase();

        System.out.println("What ingredients do you need for? (comma separated)");
        String ingredients = userInput.nextLine().toLowerCase().replace(", ", ",");

        try (PrintWriter cookbookWriter = new PrintWriter(new FileOutputStream(cookbookFile, true))) {
          cookbookWriter.println(recipeName + "|" + ingredients);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        cookbook = loadCookbook();
    }

    public void removeFromCookbook() {
        File cookbookFile = new File("C:\\Users\\Student\\workspace\\dinner-generator\\src\\main\\resources\\cookbook.txt");
        File tempCookbookFile = new File("C:\\Users\\Student\\workspace\\dinner-generator\\src\\main\\resources\\tempCookbook.txt");

        System.out.println("What dish would you like to remove?");
        String recipeToRemove = userInput.nextLine();

        try (Scanner cookbook = new Scanner(cookbookFile); PrintWriter tempCookbookWriter = new PrintWriter(new FileOutputStream(tempCookbookFile, false))) {
            while (cookbook.hasNextLine()) {
                String recipeString = cookbook.nextLine();
                String[] recipeArray = recipeString.split("\\|");
                String recipeName = recipeArray[0];

                if (!recipeName.equalsIgnoreCase(recipeToRemove)) {
                    tempCookbookWriter.println(recipeString);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        try (Scanner tempCookbook = new Scanner(tempCookbookFile); PrintWriter cookbookWriter = new PrintWriter(new FileOutputStream(cookbookFile, false))) {
            while (tempCookbook.hasNextLine()) {
                String ingredient = tempCookbook.nextLine();
                cookbookWriter.println(ingredient);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        tempCookbookFile.delete();
        cookbook = loadCookbook();
    }
}

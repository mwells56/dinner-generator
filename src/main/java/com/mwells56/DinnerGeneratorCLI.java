package com.mwells56;

import java.io.*;
import java.util.*;

public class DinnerGeneratorCLI {

    private static final String MAIN_MENU_OPTION_GENERATE_DINNER_IDEA = "Suggest a meal";
    private static final String MAIN_MENU_OPTION_KITCHEN = "Go to Kitchen";
    private static final String MAIN_MENU_OPTION_COOKBOOK = "Go to Cookbook";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_GENERATE_DINNER_IDEA, MAIN_MENU_OPTION_KITCHEN,
            MAIN_MENU_OPTION_COOKBOOK, MAIN_MENU_OPTION_EXIT};

    private static final String KITCHEN_MENU_OPTION_DISPLAY_ITEMS = "Show current inventory";
    private static final String KITCHEN_MENU_OPTION_ADD_ITEMS = "Add items to kitchen";
    private static final String KITCHEN_MENU_OPTION_REMOVE_ITEMS = "Remove items from kitchen";
    private static final String KITCHEN_MENU_OPTION_EXIT = "Return to Main Menu";

    private static final String[] KITCHEN_MENU_OPTIONS = {KITCHEN_MENU_OPTION_DISPLAY_ITEMS, KITCHEN_MENU_OPTION_ADD_ITEMS,
            KITCHEN_MENU_OPTION_REMOVE_ITEMS, KITCHEN_MENU_OPTION_EXIT };


    private static final String COOKBOOK_MENU_OPTION_DISPLAY_RECIPES = "Show all recipes";
    private static final String COOKBOOK_MENU_OPTION_ADD_RECIPE = "Add recipe to cookbook";
    private static final String COOKBOOK_MENU_OPTION_REMOVE_RECIPE = "Remove recipe from cookbook";
    private static final String COOKBOOK_MENU_OPTION_EXIT = "Return to Main Menu";

    private static final String[] COOKBOOK_MENU_OPTIONS = {COOKBOOK_MENU_OPTION_DISPLAY_RECIPES, COOKBOOK_MENU_OPTION_ADD_RECIPE,
            COOKBOOK_MENU_OPTION_REMOVE_RECIPE, COOKBOOK_MENU_OPTION_EXIT};

    private DinnerGeneratorMenu menu = new DinnerGeneratorMenu(System.in, System.out);

    private DinnerGenerator dinnerGenerator = new DinnerGenerator();
    private Kitchen kitchen = new Kitchen();
    private Cookbook cookbook = new Cookbook();

    public DinnerGeneratorCLI(DinnerGeneratorMenu dinnerGeneratorMenu) {
        this.menu = menu;
    }

    public void run() {
        boolean programRunning = true;
        while (programRunning) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_GENERATE_DINNER_IDEA)) {
                dinnerGenerator.generateRecipes();
            } else if (choice.equals(MAIN_MENU_OPTION_KITCHEN)) {
                boolean inKitchen = true;
                while (inKitchen) {
                    String kitchenMenuChoice = (String) menu.getChoiceFromOptions(KITCHEN_MENU_OPTIONS);
                    if (kitchenMenuChoice.equals(KITCHEN_MENU_OPTION_DISPLAY_ITEMS)) {
                        kitchen.displayKitchen();
                    } else if (kitchenMenuChoice.equals(KITCHEN_MENU_OPTION_ADD_ITEMS)) {
                        kitchen.addToKitchen();
                    } else if (kitchenMenuChoice.equals(KITCHEN_MENU_OPTION_REMOVE_ITEMS)) {
                        kitchen.removeFromKitchen();
                    } else if (kitchenMenuChoice.equals(KITCHEN_MENU_OPTION_EXIT)) {
                        inKitchen = false;
                    }
                }

            } else if (choice.equals(MAIN_MENU_OPTION_COOKBOOK)) {
                boolean inCookbook = true;
                while (inCookbook) {
                    String kitchenMenuChoice = (String) menu.getChoiceFromOptions(COOKBOOK_MENU_OPTIONS);
                    if (kitchenMenuChoice.equals(COOKBOOK_MENU_OPTION_DISPLAY_RECIPES)) {
                        cookbook.displayCookbook();
                    } else if (kitchenMenuChoice.equals(COOKBOOK_MENU_OPTION_ADD_RECIPE)) {
                        cookbook.addToCookbook();
                    } else if (kitchenMenuChoice.equals(COOKBOOK_MENU_OPTION_REMOVE_RECIPE)) {
                        cookbook.removeFromCookbook();
                    } else if (kitchenMenuChoice.equals(COOKBOOK_MENU_OPTION_EXIT)) {
                        inCookbook = false;
                    }
                }
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                programRunning = false;
            }
        }
    }

    public static void main(String[] args) {
        DinnerGeneratorMenu menu = new DinnerGeneratorMenu(System.in, System.out);
        DinnerGeneratorCLI cli = new DinnerGeneratorCLI(menu);
        cli.run();
    }

}

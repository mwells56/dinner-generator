package com.mwells56;

import java.io.File;
import java.io.FileNotFoundException;
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

    private DinnerGeneratorMenu menu;
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

            switch (choice) {
                case (MAIN_MENU_OPTION_GENERATE_DINNER_IDEA):
                    dinnerGenerator.generateRecipes();
                    break;
                case (MAIN_MENU_OPTION_KITCHEN):
                    boolean inKitchen = true;
                    while (inKitchen) {
                        String kitchenMenuChoice = (String) menu.getChoiceFromOptions(KITCHEN_MENU_OPTIONS);

                        switch (kitchenMenuChoice) {
                            case (KITCHEN_MENU_OPTION_DISPLAY_ITEMS):
                                kitchen.displayKitchen();
                                break;
                            case (KITCHEN_MENU_OPTION_ADD_ITEMS):
                                kitchen.addToKitchen();
                                break;
                            case (KITCHEN_MENU_OPTION_REMOVE_ITEMS):
                                kitchen.removeFromKitchen();
                                break;
                            case (KITCHEN_MENU_OPTION_EXIT):
                                inKitchen = false;
                                break;
                        }
                    }
                    break;
                case (MAIN_MENU_OPTION_COOKBOOK):
                    boolean inCookbook = true;
                    while (inCookbook) {
                        String cookbookMenuChoice = (String) menu.getChoiceFromOptions(KITCHEN_MENU_OPTIONS);

                        switch (cookbookMenuChoice) {
                            case (COOKBOOK_MENU_OPTION_DISPLAY_RECIPES):
                                cookbook.displayCookbook();
                                break;
                            case (COOKBOOK_MENU_OPTION_ADD_RECIPE):
                                cookbook.addToCookbook();
                                break;
                            case (COOKBOOK_MENU_OPTION_REMOVE_RECIPE):
                                cookbook.removeFromCookbook();
                                break;
                            case (COOKBOOK_MENU_OPTION_EXIT):
                                inCookbook = false;
                                break;
                        }
                    }
                case (MAIN_MENU_OPTION_EXIT):
                    System.out.println("Thank you for using the Dinner Generator. Bone apple tea!");
                    programRunning = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        DinnerGeneratorMenu menu = new DinnerGeneratorMenu(System.in, System.out);
        DinnerGeneratorCLI cli = new DinnerGeneratorCLI(menu);
        cli.run();
    }

}

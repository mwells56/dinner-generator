package com.mwells56;

import java.io.*;
import java.util.*;

public class DinnerGenerator {

    private PrintWriter out;
    private Scanner in;

    public List<Recipe> cookbook = Cookbook.getCookbook();
    public List<String> kitchenInventory = Kitchen.getKitchenInventory();

    private Scanner userInput = new Scanner(System.in);

    public List<Recipe> getCookbook() {
        return cookbook;
    }

    public void setCookbook(List<Recipe> cookbook) {
        this.cookbook = cookbook;
    }

    public List<String> getKitchenInventory() {
        return kitchenInventory;
    }

    public void setKitchenInventory(List<String> kitchenInventory) {
        this.kitchenInventory = kitchenInventory;
    }

    public void generateRecipes() {

    }
}

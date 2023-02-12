package com.mwells56;

import java.util.*;

public class Recipe {
    private String dishName;
    private List<String> ingredients;

    public Recipe(String dishName, List<String> ingredients) {
        this.dishName = dishName;
        this.ingredients = ingredients;
    }

    public String getDishName() {
        return dishName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}

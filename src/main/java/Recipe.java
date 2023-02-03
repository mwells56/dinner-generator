import java.util.*;

public class Recipe {
    private static String dishName;
    private static List<String> ingredients;

    public Recipe(String dishName, List<String> ingredients) {
        this.dishName = dishName;
        this.ingredients = ingredients;
    }

    public static String getDishName() {
        return dishName;
    }

    public static List<String> getIngredients() {
        return ingredients;
    }
}

import java.util.*;

public class DinnerGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> recipeMap = new HashMap<>();
        List<String> kitchenInventory = new ArrayList<>();

        System.out.print("Would you like to add any recipes? (y/n) ");
        String addRecipe = scanner.nextLine();

        while (addRecipe.equals("y")) {
            System.out.print("What is the name of the dish? ");
            String newDish = scanner.nextLine();

            System.out.print("What ingredients does the new recipe require? (separate by comma w/o space) ");
            String[] newDishIngredients = scanner.nextLine().split(",");

            List<String> recipeIngredients = new ArrayList<>();
            for (String ingredient : newDishIngredients) {
                recipeIngredients.add(ingredient.toLowerCase());
            }
            Recipe addDish = new Recipe (newDish.toLowerCase(), recipeIngredients);
            recipeMap.put(addDish.getDishName(), addDish.getIngredients());
            System.out.print("Would you like to add another recipe? (y/n) ");
            addRecipe = scanner.nextLine();
        }

        System.out.println("Would you like to add ingredients to your kitchen? (y/n) ");
        String addInventory = scanner.nextLine();

        while (addInventory.equals("y")) {
            System.out.print("What would you like to add? ");
            String newIngredient = scanner.nextLine();
            kitchenInventory.add(newIngredient);
            System.out.print("Would you like to add anything else? (y/n)");
            addInventory = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> recipe : recipeMap.entrySet()) {
            if (kitchenInventory.containsAll(recipe.getValue())) {
                System.out.println("You could make " + recipe.getKey());
            } else {
                System.out.println("You do not have the ingredients to make " + recipe.getKey());
            }
        }

    }
}

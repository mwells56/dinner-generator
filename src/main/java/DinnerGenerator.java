import java.util.*;

public class DinnerGenerator {
    public static void main(String[] args) {
        // Add scanner
        Scanner scanner = new Scanner(System.in);

        // Create Map with the dish name as the key and its ingredients as the value
        Map<String, List<String>> recipeMap = new HashMap<>();

        // Populate map with some recipes
        Recipe spaghettiAndMeatballs = new Recipe("spaghetti and meatballs", Arrays.asList("spaghetti", "meatball", "marinara"));
        recipeMap.put(spaghettiAndMeatballs.getDishName(), spaghettiAndMeatballs.getIngredients());

        Recipe avocadoToast = new Recipe("avocado toast", Arrays.asList("avocado", "bread"));
        recipeMap.put(avocadoToast.getDishName(), avocadoToast.getIngredients());

        Recipe sweetPotatoGnocchiWithMarinara = new Recipe ("sweet potato gnocchi with marinara", Arrays.asList("sweet potato", "flour", "marinara"));
        recipeMap.put(sweetPotatoGnocchiWithMarinara.getDishName(), sweetPotatoGnocchiWithMarinara.getIngredients());

        // Create kitchen inventory
        List<String> kitchenInventory = new ArrayList<>();

        // Populate kitchen inventory
        kitchenInventory.add("spaghetti");
        kitchenInventory.add("meatball");
        kitchenInventory.add("marinara");
        kitchenInventory.add("bread");
        kitchenInventory.add("avocado");
        kitchenInventory.add("steak");
        kitchenInventory.add("salmon");
        kitchenInventory.add("tofu");
        kitchenInventory.add("spinach");
        kitchenInventory.add("kale");
        kitchenInventory.add("carrot");
        kitchenInventory.add("celery");
        kitchenInventory.add("onion");
        kitchenInventory.add("russet potato");
        kitchenInventory.add("sweet potato");
        kitchenInventory.add("flour");
        kitchenInventory.add("butter");
        kitchenInventory.add("sausage");
        kitchenInventory.add("egg");
        kitchenInventory.add("syrup");

        // Ask user if there are any new recipes to add
        System.out.print("Would you like to add any recipes? (y/n) ");
        String addRecipe = scanner.nextLine();

        while (addRecipe.equals("y")) {
            // Ask for dish name and ingredients
            System.out.print("What is the name of the dish? ");
            String newDish = scanner.nextLine();

            System.out.print("What ingredients does the new recipe require? (separate by commas) ");
            String[] newDishIngredients = scanner.nextLine().split(", ");

            // Pull ingredients into a list to be used for a new recipe instance
            List<String> recipeIngredients = new ArrayList<>();
            for (String ingredient : newDishIngredients) {
                recipeIngredients.add(ingredient.toLowerCase());
            }
            Recipe addDish = new Recipe (newDish.toLowerCase(), recipeIngredients);

            // Add new recipe to the map
            recipeMap.put(addDish.getDishName(), addDish.getIngredients());
            System.out.print("Would you like to add another recipe? (y/n) ");
            addRecipe = scanner.nextLine();
        }

        // Ask user if they want to add or remove ingredients from the kitchen
        System.out.print("Would you like to add ingredients to your kitchen? (y/n) ");
        String addInventory = scanner.nextLine();

        while (addInventory.equals("y")) {
            System.out.print("What would you like to add? ");
            String newIngredient = scanner.nextLine();
            kitchenInventory.add(newIngredient);
            System.out.print("Would you like to add anything else? (y/n) ");
            addInventory = scanner.nextLine();
        }

        System.out.print("Would you like to remove ingredients to your kitchen? (y/n) ");
        String removeInventory = scanner.nextLine();

        while (removeInventory.equals("y")) {
            System.out.print("What would you like to remove? ");
            String newIngredient = scanner.nextLine();
            kitchenInventory.remove(newIngredient);
            System.out.print("Would you like to add anything else? (y/n) ");
            removeInventory = scanner.nextLine();
        }

        // If the kitchen contains every ingredient needed for a recipe, print the dish name
        System.out.println("You have the ingredients to make the following recipes:");
        for (Map.Entry<String, List<String>> recipe : recipeMap.entrySet()) {
            if (kitchenInventory.containsAll(recipe.getValue())) {
                System.out.println(recipe.getKey());
            }
        }
    }
}

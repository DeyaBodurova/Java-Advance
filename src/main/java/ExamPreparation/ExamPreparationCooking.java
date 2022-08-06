package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class ExamPreparationCooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquids::add);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);
        Map<String, Integer> foodCooked = new TreeMap<>();
        foodCooked.put("Bread", 0);
        foodCooked.put("Cake", 0);
        foodCooked.put("Pastry", 0);
        foodCooked.put("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int tempIngredient = ingredients.peek() + 3;
            int sum = liquids.poll() + ingredients.pop();
            String food = "";
            switch (sum) {
                case 25:
                    foodCooked.replace("Bread", foodCooked.get("Bread"), foodCooked.get("Bread") + 1);
                    break;
                case 50:
                    foodCooked.replace("Cake", foodCooked.get("Cake"), foodCooked.get("Cake") + 1);
                    break;
                case 75:
                    foodCooked.replace("Pastry", foodCooked.get("Pastry"), foodCooked.get("Pastry") + 1);
                    break;
                case 100:
                    foodCooked.replace("Fruit Pie", foodCooked.get("Fruit Pie"), foodCooked.get("Fruit Pie") + 1);
                    break;
                default:
                    ingredients.push(tempIngredient);
                    break;
            }
        }
        if (!foodCooked.containsValue(0)) {
            System.out.print("Wohoo! You succeeded in cooking all the food!\n");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            String remainingLiquids = liquids.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.print("Liquids left: " + remainingLiquids);
            System.out.println();
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            String remainingIngredients = ingredients.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.print("Ingredients left: " + remainingIngredients);
            System.out.println();
        }
        foodCooked.entrySet().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

    }
}



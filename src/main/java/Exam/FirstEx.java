package Exam;

import java.util.*;

public class FirstEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Double> milkValue = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(milkValue::add);
        ArrayDeque<Double> cacaoPowderValue = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cacaoPowderValue::push);
        Map<String, Integer> chocolates = new TreeMap<>();
        chocolates.put("Milk Chocolate",0);
        chocolates.put("Dark Chocolate",0);
        chocolates.put("Baking Chocolate",0);
        while (!milkValue.isEmpty() && !cacaoPowderValue.isEmpty()) {
            double cacaoPowderValueCurrent = cacaoPowderValue.peek();
            double newMilk = milkValue.peek() + 10;
            int cacaoPercentage = (int)((cacaoPowderValueCurrent / (milkValue.poll() + cacaoPowderValue.pop()))*100);
            switch (cacaoPercentage) {
                case 30:
                    chocolates.replace("Milk Chocolate", chocolates.get("Milk Chocolate"),
                            chocolates.get("Milk Chocolate") + 1);
                    break;
                case 50:
                    chocolates.replace("Dark Chocolate", chocolates.get("Dark Chocolate"),
                            chocolates.get("Dark Chocolate") + 1);
                    break;
                case 100:
                    chocolates.replace("Baking Chocolate", chocolates.get("Baking Chocolate"),
                            chocolates.get("Baking Chocolate") + 1);
                    break;
                default:
                    milkValue.add(newMilk);
                    break;
            }

        }
        if (!chocolates.containsValue(0)) {
            System.out.printf("It’s a Chocolate Time. All chocolate types are prepared.\n");
        } else {
            System.out.printf("Sorry, but you didn't succeed to prepare all types of chocolates.\n");
        }
        //" # {chocolate type} --> {amount}".
        chocolates.entrySet().removeIf(e -> e.getValue().equals(0));
        chocolates.entrySet().forEach(e -> System.out.println("# " + e.getKey() + " --> " + e.getValue()));

    }
}


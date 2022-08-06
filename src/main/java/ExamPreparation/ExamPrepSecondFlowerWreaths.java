package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ExamPrepSecondFlowerWreaths {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(lilies::push);
        Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(roses::add);
        int wreaths = 0;
        int remainingFlowers = 0;
        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int sum = lilies.peek() + roses.peek();
            while (sum > 15) {
                sum -= 2;
            }
            if (sum == 15) {
                lilies.pop();
                roses.poll();
                wreaths++;
                if (wreaths == 5) {
                    break;
                }
            } else if (sum < 15) {
                remainingFlowers += sum;
                lilies.pop();
                roses.poll();
            }
        }
        if (remainingFlowers >= 15) {
            int additionalWreaths = remainingFlowers / 15;
            wreaths = wreaths + additionalWreaths;
            remainingFlowers -= additionalWreaths;
        }
        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!\n", wreaths);
        } else if (wreaths < 5) {
            System.out.printf("You didn't make it, you need %d wreaths more!\n", 5 -wreaths);
        }
    }
}

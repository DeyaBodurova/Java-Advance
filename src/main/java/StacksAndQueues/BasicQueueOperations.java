package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] commands = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int toAdd = commands[0];
        int toPoll = commands[1];
        int checkIfPresent = commands[2];
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        while (toAdd > 0) {
            queue.add(numbers.get(0));
            numbers.remove(0);
            toAdd--;
        }
        while (toPoll > 0) {
            queue.poll();
            toPoll--;
        }
        if(queue.contains(checkIfPresent)) {
            System.out.println("true");
        } else {
            if (!queue.isEmpty()) {
                int smallest = Integer.MAX_VALUE;
                while (!queue.isEmpty()) {
                    if (queue.peek() < smallest) {
                        smallest = queue.peek();
                    }
                    queue.poll();
                }
                System.out.println(smallest);
            } else {
                System.out.println(0);
            }
        }
    }
}

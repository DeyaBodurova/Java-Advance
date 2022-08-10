package StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStackOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int toPush = data[0];
        int toPop = data[1];
        int checkIfPresent = data[2];
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (toPush > 0) {
            stack.push(numbers.get(0));
            numbers.remove(0);
            toPush--;
        }

        while (toPop > 0) {
            stack.pop();
            toPop--;
        }

        if (!stack.isEmpty()) {
            if (stack.contains(checkIfPresent)) {
                System.out.println("true");
            } else {
                int smallest = Integer.MAX_VALUE;
                while (!stack.isEmpty()) {
                    if(stack.peek() < smallest){
                        smallest = stack.pop();
                    } else {
                        stack.pop();
                    }
                }
                System.out.println(smallest);
            }
        } else {
            System.out.println(0);
        }
    }
}

package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        boolean isMatch = true;
        //TODO to fix
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < input.length / 2; i++) {
            stack.push(input[i]);
        }
        for (int i = input.length / 2; i < input.length; i++) {
            queue.add(input[i]);
        }
        if (!stack.isEmpty() && !queue.isEmpty()) {
            while (!stack.isEmpty() && !queue.isEmpty()) {
                Character current = stack.peek();
                switch (current) {
                    case '{':
                        if (queue.peek().equals('}')) {
                            stack.pop();
                            queue.poll();
                        } else {
                            isMatch = false;
                            break;
                        }
                        break;
                    case '[':
                        if (queue.peek().equals(']')) {
                            stack.pop();
                            queue.poll();
                        } else {
                            isMatch = false;
                            break;
                        }
                        break;
                    case '(':
                        if (queue.peek().equals(')')) {
                            stack.pop();
                            queue.poll();
                        } else {
                            isMatch = false;
                            break;
                        }
                        break;
                    default:
                        isMatch = false;
                        break;
                }
                if (!isMatch) {
                    break;
                }
            }
            if (isMatch) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("NO");
        }
    }
}
//}

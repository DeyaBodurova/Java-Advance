package ExamPreparation;

import java.util.Scanner;

public class ExamPreparationMouseAndCheese {
    private static int row = 0;
    private static int col = 0;
    private static int eatenCheese = 0;
    private static boolean mouseIsInField = true;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("M")) {
                row = i;
                col = line.indexOf("M");
            }
        }
        String command = sc.nextLine();

        while (!command.equals("end")) {
            if (command.equals("up")) {
                moveMouse(matrix, -1, 0);
            } else if (command.equals("down")) {
                moveMouse(matrix, 1, 0);
            } else if (command.equals("right")) {
                moveMouse(matrix, 0, 1);
            } else if (command.equals("left")) {
                moveMouse(matrix, 0, -1);
            }
            if (!mouseIsInField) {
                break;
            }

            command = sc.nextLine();
        }

        if (!mouseIsInField) {
            System.out.print("Where is the mouse?\n");
        }
        if (eatenCheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - eatenCheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", eatenCheese);
        }

        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void moveMouse(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nexCol = col + colMutator;
        boolean isBonusHit = false;

        if (!isInField(matrix, nextRow, nexCol)) {
            matrix[row][col] = '-';
            mouseIsInField = false;
            return;
        }

        if (matrix[nextRow][nexCol] == 'c') {
            eatenCheese++;
        } else if (matrix[nextRow][nexCol] == 'B') {
            isBonusHit = true;
        }

        matrix[row][col] = '-';
        matrix[nextRow][nexCol] = 'M';
        row = nextRow;
        col = nexCol;

        if (isBonusHit) {
            moveMouse(matrix, rowMutator, colMutator);
        }
    }

    public static boolean isInField(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}

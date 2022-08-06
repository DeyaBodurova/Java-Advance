package Exam;

import java.util.Scanner;

public class SecondEx {
    private static int rows = 0;
    private static int cols = 0;
    private static int house = 0;
    private static boolean roberIsInField = true;
    private static int totalStolen = 0;
    private static boolean policeHit = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] commands = sc.nextLine().split(",");
        char[][] matrix = new char[n][n];

        String line = sc.nextLine().replace(" ", "");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                char symbol = line.charAt(col);
                matrix[row][col] = symbol;
                if (symbol == '$') {
                    house++;
                } else if (symbol == 'D') {
                    rows = row;
                    cols = col;
                }
            }
            if (row < n - 1) {
                line = sc.nextLine().replace(" ", "");
            }
        }
        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            switch (currentCommand) {
                case "up":
                    moveRober(matrix, -1, 0);
                    break;
                case "down":
                    moveRober(matrix, 1, 0);
                    break;
                case "right":
                    moveRober(matrix, 0, 1);
                    break;
                case "left":
                    moveRober(matrix, 0, -1);
                    break;
            }
            if(policeHit) {
                break;
            }
        }
        if (!policeHit) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", totalStolen);
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static void moveRober(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = rows + rowMutator;
        int nexCol = cols + colMutator;
        int stolen = 0;

        if (!isInField(matrix, nextRow, nexCol)) {
            roberIsInField = false;
            System.out.printf("You cannot leave the town, there is police outside!\n");
            return;
        }
        if (matrix[nextRow][nexCol] == '$') {
            house++;
            stolen = nexCol * nextRow;
            totalStolen += stolen;
            System.out.printf("You successfully stole %d$.\n", stolen);
        } else if (matrix[nextRow][nexCol] == 'P') {
            policeHit = true;
            System.out.printf("You got caught with %d$, and you are going to jail.\n", totalStolen);
            matrix[rows][cols] = '+';
            matrix[nextRow][nexCol] = '#';
            return;
        }

        matrix[rows][cols] = '+';
        matrix[nextRow][nexCol] = 'D';
        rows = nextRow;
        cols = nexCol;

    }

    public static boolean isInField(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}


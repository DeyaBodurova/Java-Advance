package ExamPreparation;

import java.util.Scanner;

public class ExamPrepSecondBomb {
    private static int rowS = 0;
    private static int colS = 0;
    private static int totalBombs = 0;
    private static int hitBombs = 0;
    private static boolean sapperIsInField = true;
    private static boolean isEndpointHit = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        String[] commands = sc.nextLine().split(",");
        char[][] field = new char[size][size];

        String line = sc.nextLine().replace(" ", "");
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                char symbol = line.charAt(col);
                field[row][col] = symbol;
                if (symbol == 'B') {
                    totalBombs++;
                } else if (symbol == 's') {
                    rowS =row;
                    colS = col;
                }
            }
            if (row < size - 1) {
                line = sc.nextLine().replace(" ", "");
            }
        }
        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            switch (currentCommand) {
                case "up":
                    moveSapper(field, -1, 0);
                    break;
                case "down":
                    moveSapper(field, 1, 0);
                    break;
                case "right":
                    moveSapper(field, 0, 1);
                    break;
                case "left":
                    moveSapper(field, 0, -1);
                    break;
            }
            if (totalBombs == hitBombs) {
                System.out.println("Congratulations! You found all bombs!\n");
                break;
            }
            if (isEndpointHit) {
                System.out.printf("END! %d bombs left on the field\n", totalBombs - hitBombs);
                break;
            }
            if (i == commands.length - 1) {
                System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)\n",
                        totalBombs - hitBombs, rowS, colS);
            }
        }
    }

    private static void moveSapper(char[][] field, int rowMutator, int colMutator) {
        int nextRow = rowS + rowMutator;
        int nexCol = colS + colMutator;

        if (!isInField(field, nextRow, nexCol)) {
            sapperIsInField = false;
            return;
        }
        if (field[nextRow][nexCol] == 'B') {
            hitBombs++;
            System.out.print("You found a bomb!\n");

        } else if (field[nextRow][nexCol] == 'e') {
            isEndpointHit = true;
            return;
        }

        field[rowS][colS] = '+';
        field[nextRow][nexCol] = 's';
        rowS = nextRow;
        colS = nexCol;

        if (isEndpointHit) {
            return;
        }
    }

    public static boolean isInField(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }
}

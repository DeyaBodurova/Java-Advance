package MultidimensionalArrays;

import java.util.Scanner;

public class MultidimensionalArraysFillTheMatrix {
    public static void main(String[] args) {

        //TODO to check it in judge before commit to github

        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(", ");
        int size = Integer.parseInt(data[0]);
        String type = data[1];
        int[][] matrix = new int[size][size];

        if (type.equalsIgnoreCase("A")) {
            patternA(matrix);
        } else if (type.equalsIgnoreCase("B")) {
            patternB(matrix);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void patternA(int[][] matrix) {
        int n = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row <= matrix.length - 1; row++) {
                matrix[row][col] = n;
                n++;
            }
        }
    }

    private static void patternB(int[][] matrix) {
        int m = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = m;
                    m++;
                }
            } else if (col % 2 != 0) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = m;
                    m++;
                }
            }

        }
    }
}

package MultidimensionalArraysExercises;

import java.util.*;

public class A12TheMatrix2 {

    private static int[] rowDelta = {-1, 1, 0, 0};
    private static int[] colDelta = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.next().charAt(0);
            }
        }

        char fillChar = scanner.next().charAt(0);

        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();

        char startChar = matrix[startRow][startCol];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            matrix[currRow][currCol] = fillChar;

            for (int i = 0; i < 4; i++) {
                int newRow = currRow + rowDelta[i];
                int newCol = currCol + colDelta[i];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && matrix[newRow][newCol] == startChar) {
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}


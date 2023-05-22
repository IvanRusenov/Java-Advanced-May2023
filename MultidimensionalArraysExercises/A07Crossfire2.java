package MultidimensionalArraysExercises;

import java.util.*;

public class A07Crossfire2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();


        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();

        int value = 1;

        for (int row = 0; row < rows; row++) {

            List<Integer> currentRow = new ArrayList<>();

            for (int col = 0; col < cols; col++) {

                currentRow.add(value++);

            }

            matrix.add(currentRow);

        }

        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {

            String[] tokens = input.split("\\s+");

            int targetRow = Integer.parseInt(tokens[0]);
            int targetCol = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            for (int row = targetRow - radius; row <= targetRow + radius; row++) {
                if (isInMatrix(row, targetCol, matrix) && row != targetRow) {
                    matrix.get(row).remove(targetCol);
                }
            }

            for (int col = targetCol + radius; col >= targetCol - radius; col--) {
                if (isInMatrix(targetRow, col, matrix)) {
                    matrix.get(targetRow).remove(col);
                }
            }

            matrix.removeIf(List::isEmpty);

            input = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

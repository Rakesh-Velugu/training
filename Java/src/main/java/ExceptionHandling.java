import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String args[]) {
        int[][] matrix = new int[][]{new int[]{0, 1, 0, 1, 1}, new int[]{1, 1, 0, 0, 0}, new int[]{1, 1, 1, 1, 0}, new int[]{0, 0, 0, 0, 1},
                new int[]{1, 0, 1, 0, 1}};

        String exit = "Y";
        while (exit.equals("Y")) {
            System.out.println("The matrix is");

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Please enter indexes");

            Scanner sc = new Scanner(System.in);

            int row = sc.nextInt();
            int column = sc.nextInt();

            int count = 0;

            try {
                int number = matrix[row - 1][column];
                count++;
            } catch (Exception ignored) {

            }

            try {
                int number = matrix[row][column - 1];
                count++;
            } catch (Exception ignored) {

            }

            try {
                int number = matrix[row + 1][column];
                count++;
            } catch (Exception ignored) {

            }

            try {
                int number = matrix[row][column + 1];
                count++;
            } catch (Exception ignored) {

            } finally {
                System.out.println("Total count is " + count);
            }
            System.out.println("Do you want to exit (Y/N) :");
            exit = sc.next();
        }
    }
}

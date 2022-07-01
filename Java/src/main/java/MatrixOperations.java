import java.util.Scanner;

public class MatrixOperations {

    public static void main(String args[]) {
        int[][] matrix = new int[][]{new int[]{0,1,0,1,1}, new int[]{1,1,0,0,0}, new int[]{1,1,1,1,0}, new int[]{0,0,0,0,1},
                new int[]{1,0,1,0,1}};

        for (int i=0; i<matrix.length; i++) {
            for (int j=0 ;j<matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Getting values of the immediate indexes that is reachable from given indexes");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter row and column");

        int i = scanner.nextInt();
        int j = scanner.nextInt();

        if (i-1 >= 0 && j-1 >= 0) {
            System.out.print(matrix[i-1][j-1]+ " ");
        }

        if (i-1 >= 0) {
            System.out.print(matrix[i-1][j]+ " ");
        }

        if (i+1 < matrix.length && j+1 < matrix[i].length) {
            System.out.print(matrix[i+1][j+1]+ " ");
        }
        if (j-1 >= 0) {
            System.out.print(matrix[i][j-1]+ " ");
        }
        if (j+1 < matrix[i].length) {
            System.out.print(matrix[i][j+1]+ " ");
        }
        if (j-1 >=0 && i+1 < matrix.length) {
            System.out.print(matrix[i+1][j-1]+ " ");
        }
        if (i+1 < matrix.length) {
            System.out.print(matrix[i+1][j]+ " ");
        }
        if (i-1 >=0 && j+1 < matrix[i].length) {
            System.out.print(matrix[i-1][j+1]+ " ");
        }


        System.out.println();
        System.out.println("Printing two dimensional Array based on 1 row in normal way and another row in reverse order follows");
        for (int i1 = 0; i1<matrix.length; i1++) {
            if (i1 % 2 == 0) {
                for (int j1 = 0; j1 < matrix[i].length; j1++) {
                    System.out.print(matrix[i1][j1] + " ");
                }
            } else {
                for (int j1 = matrix[i1].length-1; j1 >= 0; j1--) {
                    System.out.print(matrix[i1][j1] + " ");
                }
            }
            System.out.println();
        }
    }
}

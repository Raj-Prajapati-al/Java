import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();
        
        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];
        
        System.out.println("Enter elements of the first matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println("Enter elements of the second matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }
        
        int[][] sum = new int[rows][columns];
        int[][] difference = new int[rows][columns];
        
        // Matrix addition and subtraction 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
                difference[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        
        System.out.println("Sum of matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Difference of matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(difference[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}

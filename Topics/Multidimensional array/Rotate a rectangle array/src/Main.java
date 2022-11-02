import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sizes = scanner.nextLine();
        String[] arguments = sizes.split(" ");
        int n = Integer.parseInt(arguments[0]);
        int m = Integer.parseInt(arguments[1]);
        int[][] matrix = new int[n][m];
        int[][] newMatrix = new int[m][n];
        for (int i = 0; i < n; i++) {
            String nextLine = scanner.nextLine();
            String[] strArray = nextLine.split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(strArray[j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                newMatrix[i][n - j - 1] = matrix[j][i];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
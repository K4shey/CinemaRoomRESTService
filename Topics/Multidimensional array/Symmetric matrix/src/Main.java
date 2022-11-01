import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            String nextLine = scanner.nextLine();
            String[] strArray = nextLine.split(" ");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.parseInt(strArray[j]);
            }
        }

        String result = "YES";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    continue;
                }
                if (matrix[i][j] != matrix[j][i]) {
                    result = "NO";
                }
            }
        }
        System.out.println(result);
    }
}
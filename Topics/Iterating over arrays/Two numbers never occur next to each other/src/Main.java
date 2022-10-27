import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        String array = scanner.nextLine();
        String[] strArray = array.split(" ");
        int[] intArray = new int[size];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        String valuesStr = scanner.nextLine();
        String[] valuesArrayStr = valuesStr.split(" ");
        int n = Integer.parseInt(valuesArrayStr[0]);
        int m = Integer.parseInt(valuesArrayStr[1]);

        boolean result = true;
        for (int i = 0; i < intArray.length; i++) {
            if (i == 0) {
                if (intArray[i] == n && intArray[i + 1] == m) {
                    result = false;
                }
            } else if (i == intArray.length - 1) {
                if (intArray[i] == n && intArray[i - 1] == m) {
                    result = false;
                }
            } else {
                if (intArray[i] == n && (intArray[i + 1] == m || intArray[i - 1] == m)) {
                    result = false;
                }
            }
        }
        System.out.println(result);
    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();

        String[] array = input.split(" ");
        int min = Integer.parseInt(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (Integer.parseInt(array[i]) < min) {
                min = Integer.parseInt(array[i]);
            }
        }
        System.out.println(min);
    }
}
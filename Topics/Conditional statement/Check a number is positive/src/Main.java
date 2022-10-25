import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer input = scanner.nextInt();
        if (input > 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
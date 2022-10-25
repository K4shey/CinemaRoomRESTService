import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer hours_first = scanner.nextInt();
        Integer minutes_first = scanner.nextInt();
        Integer seconds_first = scanner.nextInt();
        Integer hours_second = scanner.nextInt();
        Integer minutes_second = scanner.nextInt();
        Integer seconds_second = scanner.nextInt();

        Integer result = (seconds_second + minutes_second * 60 + hours_second * 3600)
                - (seconds_first + minutes_first * 60 + hours_first * 3600);
        System.out.println(result);



    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;
        double r = 0.0;
        String nextLine = scanner.nextLine();
        if ("triangle".equals(nextLine)) {
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();
            double p = (a + b + c) / 2;
            Double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println(s);
        } else if ("rectangle".equals(nextLine)) {
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            Double s = a * b;
            System.out.println(s);
        } else if ("circle".equals(nextLine)) {
            r = scanner.nextDouble();
            Double pi = 3.14;
            Double s = pi * Math.pow(r, 2);
            System.out.println(s);
        }
    }
}
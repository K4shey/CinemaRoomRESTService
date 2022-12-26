import java.util.Scanner;

class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            int nextNumber = scanner.nextInt();
            if (nextNumber == 0) {
                break;
            }
            if (nextNumber % 2 == 0) {
                System.out.println(nextNumber);
            }
        }
    }
}
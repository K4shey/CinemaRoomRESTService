import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> list = Arrays.asList(input.split(" "));
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                System.out.print(list.get(i) + " ");
            }
        }
    }

}
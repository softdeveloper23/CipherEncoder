package encoder;

import java.util.Scanner;

public class CipherEncoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input encoded string:");
        String input = scanner.nextLine();
        System.out.println("The result:");
        decoder(input);
        scanner.close();
    }

    private static void decoder(String input) {
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (c.equals('0')) {
                System.out.print("1");
            } else if (c.equals(' ')) {
                System.out.print("2");
            }
        }
    }
}

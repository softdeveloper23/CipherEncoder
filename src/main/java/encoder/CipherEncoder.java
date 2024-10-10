package encoder;

import java.util.Scanner;

public class CipherEncoder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        System.out.println("Input string:");
        Scanner scanner = new Scanner(System.in);
        String original = scanner.nextLine();

        for (int i = 0; i < original.length(); i++) {
            sb.append(original.charAt(i));
            if (i != original.length() - 1) {
                sb.append(' ');
            }
        }

        String result = sb.toString();
        System.out.println(result);
        scanner.close();
    }
}

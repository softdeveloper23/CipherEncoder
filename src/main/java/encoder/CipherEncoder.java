package encoder;

import java.util.Scanner;

public class CipherEncoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] charArray = input.toCharArray();
        convertToBinary(charArray);
        scanner.close();
    }

    private static void convertToBinary(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

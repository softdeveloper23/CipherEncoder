package encoder;

import java.util.Scanner;

public class CipherEncoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();
        char[] charArray = input.toCharArray();
        System.out.println("The result:");
        convertToBinary(charArray);
        scanner.close();
    }

    private static void convertToBinary(char[] arr) {
        String result;
        for (int i = 0; i < arr.length; i++) {
            result = Integer.toBinaryString(arr[i]);
            String formattedBinaryString = String.format("%7s", result).replace(' ', '0');
            System.out.println(arr[i] + " = " + formattedBinaryString);
        }
    }
}

package encoder;

import java.util.Scanner;

public class CipherEncoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input encoded string:");
        String input = scanner.nextLine();
        System.out.println("The result:");
        String binaryString = decoder(input);
        convertBinaryToText(binaryString);
        scanner.close();
    }

    private static String decoder(String input) {
        String[] tokens = input.split(" ");
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < tokens.length; i += 2) {
            String prefix = tokens[i];
            String zeroSequence = tokens[i + 1];
            char bit;

            if (prefix.equals("0")) {
                bit = '1';
            } else if (prefix.equals("00")) {
                bit = '0';
            } else {
                return "Invalid prefix: " + prefix;
            }

            int count = zeroSequence.length();
            for (int j = 0; j < count; j++) {
                output.append(bit);
            }
        }
        String binaryString = output.toString();
        return binaryString;
    }

    private static void convertBinaryToText(String binaryString) {
        int blockSize = 7;
        int length = binaryString.length();
        StringBuilder textOutput = new StringBuilder();

        for (int i = 0; i < length; i += blockSize) {
            int endIndex = Math.min(i + blockSize, length);
            String block = binaryString.substring(i, endIndex);
            // ...rest of the loop...
        }
    }
}
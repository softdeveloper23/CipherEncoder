package encoder;

import java.util.Scanner;

public class CipherEncoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation;
        do {
            System.out.println("Please input operation (encode/decode/exit):");
            operation = scanner.nextLine();
            userInterface(scanner, operation);
        } while (!operation.equals("exit"));

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

            if (block.length() < blockSize) {
                block = String.format("%7s", block).replace(' ', '0');
            }

            int charCode = Integer.parseInt(block, 2);
            char character = (char) charCode;
            textOutput.append(character);
        }
        System.out.println(textOutput.toString());
    }

    private static void userInterface(Scanner scanner, String operation) {
        switch (operation) {
            case "encode":
                System.out.println("Encoded string:");
                break;
            case "decode":
                System.out.println("Input encoded string:");
                String input = scanner.nextLine();
                String binaryString = decoder(input);
                System.out.println("Decoded string:");
                convertBinaryToText(binaryString);
                break;
            case "exit":
                break;
            default:
                System.out.println("There is no '" + operation + "' operation");
        }
    }
}
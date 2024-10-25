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
        System.out.println("Bye!");
        scanner.close();
    }

    private static void encoder(String input) {
        // Step 1: Convert input string to a binary string with 7 bits per character
        StringBuilder binaryString = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            String binaryChar = Integer.toBinaryString(input.charAt(i));
            String formattedBinaryString = String.format("%7s", binaryChar).replace(' ', '0');
            binaryString.append(formattedBinaryString);
        }

        // Step 2: Process the binary string to generate the encoded message
        StringBuilder encodedMessage = new StringBuilder();
        int i = 0;
        while (i < binaryString.length()) {
            char currentBit = binaryString.charAt(i);
            String firstBlock = (currentBit == '1') ? "0" : "00";
            int runLength = 1;
            // Count the number of consecutive identical bits
            while ((i + runLength) < binaryString.length() && binaryString.charAt(i + runLength) == currentBit) {
                runLength++;
            }
            // Create the second block with a number of '0's equal to the run length
            StringBuilder secondBlock = new StringBuilder();
            for (int j = 0; j < runLength; j++) {
                secondBlock.append('0');
            }
            // Append the blocks to the encoded message
            encodedMessage.append(firstBlock);
            encodedMessage.append(' ');
            encodedMessage.append(secondBlock);
            // Add a space if there are more bits to process
            if (i + runLength < binaryString.length()) {
                encodedMessage.append(' ');
            }
            // Move to the next sequence of bits
            i += runLength;
        }
        // Print the encoded message
        System.out.println(encodedMessage.toString());
    }

    private static String decoder(String input) {
        // Check for invalid characters (only '0' and ' ' are allowed)
        if (!input.matches("[0 ]+")) {
            System.out.println("Encoded string is not valid.");
            return null;
        }

        String[] tokens = input.split(" ");

        // Check if the number of tokens is even
        if (tokens.length % 2 != 0) {
            System.out.println("Encoded string is not valid.");
            return null;
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < tokens.length; i += 2) {
            String prefix = tokens[i];
            String zeroSequence = tokens[i + 1];
            char bit;

            // Check that the prefix is '0' or '00'
            if (prefix.equals("0")) {
                bit = '1';
            } else if (prefix.equals("00")) {
                bit = '0';
            } else {
                System.out.println("Encoded string is not valid.");
                return null;
            }

            // Check that the zeroSequence consists only of '0's
            if (!zeroSequence.matches("0+")) {
                System.out.println("Encoded string is not valid.");
                return null;
            }

            int count = zeroSequence.length();
            for (int j = 0; j < count; j++) {
                output.append(bit);
            }
        }

        String binaryString = output.toString();

        // Check if the length of the binary string is a multiple of 7
        if (binaryString.length() % 7 != 0) {
            System.out.println("Encoded string is not valid.");
            return null;
        }

        return binaryString;
    }

    private static void convertBinaryToText(String binaryString) {
        int blockSize = 7;
        int length = binaryString.length();
        StringBuilder textOutput = new StringBuilder();

        for (int i = 0; i < length; i += blockSize) {
            int endIndex = Math.min(i + blockSize, length);
            String block = binaryString.substring(i, endIndex);

            // In case the last block is less than 7 bits (should not happen due to earlier checks)
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
                System.out.println("Input string:");
                String inputString = scanner.nextLine();
                System.out.println("Encoded string:");
                encoder(inputString);
                break;
            case "decode":
                System.out.println("Input encoded string:");
                String inputCode = scanner.nextLine();
                String binaryString = decoder(inputCode);
                if (binaryString != null) {
                    System.out.println("Decoded string:");
                    convertBinaryToText(binaryString);
                }
                // If binaryString is null, the error message has already been printed
                break;
            case "exit":
                // Do nothing here; the loop will exit
                break;
            default:
                System.out.println("There is no '" + operation + "' operation");
        }
    }
}

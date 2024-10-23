package encoder;

import java.util.Scanner;

public class CipherEncoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input encoded string:");
        String input = scanner.nextLine();
        char[] charArray = input.toCharArray();
        System.out.println("The result:");
        decoder(charArray);
        scanner.close();
    }

    private static void decoder(char[] arr) {
        int block1 = 1;
        int block2 = 0;
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = i + 2;

            if (arr[i] == '0' && arr[j] == ' ') {
                while (k < arr.length && arr[k] == '0') {
                    System.out.print(block1);
                    count++;
                    k = k + 1;
                }
            }
        }
    }
}

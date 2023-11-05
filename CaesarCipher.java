import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String message, int shift) {
        StringBuilder result = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) ((ch - base + shift) % 26 + base);
            }
            result.append(ch);
        }

        return result.toString();
    }

    public static String decrypt(String message, int shift) {
        return encrypt(message, 26 - shift); // Decryption is just encryption with the opposite shift
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a message to encrypt: ");
        String message = scanner.nextLine();

        System.out.print("Enter the shift value: ");
        int shift = scanner.nextInt();

        String encryptedMessage = encrypt(message, shift);
        System.out.println("Encrypted message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, shift);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
import java.util.Scanner;

public class Chuong3 {
    // Bài tập 3.12.1

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập các khóa X, Y, Z từ bàn phím
        System.out.print("Nhập giá trị của khóa X (chuỗi bit độ dài 19): ");
        String keyX = scanner.nextLine();
        System.out.print("Nhập giá trị của khóa Y (chuỗi bit độ dài 22): ");
        String keyY = scanner.nextLine();
        System.out.print("Nhập giá trị của khóa Z (chuỗi bit độ dài 23): ");
        String keyZ = scanner.nextLine();

        // Nhập thông điệp cần mã hóa từ bàn phím
        System.out.print("Nhập thông điệp cần mã hóa (dãy bit): ");
        String message = scanner.nextLine();

        // Mã hóa thông điệp
        String encryptedMessage = encrypt(message, keyX, keyY, keyZ);
        System.out.println("Thông điệp đã được mã hóa: " + encryptedMessage);

        // Giải mã thông điệp
        String decryptedMessage = decrypt(encryptedMessage, keyX, keyY, keyZ);
        System.out.println("Thông điệp đã được giải mã: " + decryptedMessage);

        scanner.close();
    }

    // Hàm mã hóa thông điệp
    public static String encrypt(String message, String keyX, String keyY, String keyZ) {
        StringBuilder encryptedMessage = new StringBuilder();
        // Lặp qua từng bit của thông điệp và thực hiện phép XOR với các khóa X, Y, Z tương ứng
        for (int i = 0; i < message.length(); i++) {
            char originalBit = message.charAt(i);
            char encryptedBit = (char) (originalBit ^ (keyX.charAt(i % keyX.length()) ^
                    keyY.charAt(i % keyY.length()) ^
                    keyZ.charAt(i % keyZ.length())));
            encryptedMessage.append(encryptedBit);
        }
        return encryptedMessage.toString();
    }

    // Hàm giải mã thông điệp
    public static String decrypt(String encryptedMessage, String keyX, String keyY, String keyZ) {
        // Vì A5/1 là thuật toán đối xứng, quá trình giải mã giống như quá trình mã hóa
        return encrypt(encryptedMessage, keyX, keyY, keyZ);
    }
}

public class Chuong2 {
    // Bài tập 2.11.1

    public static String encrypt(String msg, int key) {
        char arr[] = new char[msg.length()];
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            if (Character.isLetter(c)) {
                int e = (int) c + key;
                if (Character.isLowerCase(c)) {
                    e = e > (int) 'z' ? e - 26 : e;
                } else {
                    e = e > (int) 'Z' ? e - 26 : e;
                }
                arr[i] = (char) e;
            } else {
                arr[i] = c;
            }
        }
        return new String(arr);
    }

    public static String decrypt(String msg, int key) {
        char arr[] = new char[msg.length()];
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            if (Character.isLetter(c)) {
                int e = (int) c - key;
                if (Character.isLowerCase(c)) {
                    e = e < (int) 'a' ? e + 26 : e;
                } else {
                    e = e < (int) 'A' ? e + 26 : e;
                }
                arr[i] = (char) e;
            } else {
                arr[i] = c;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        int key = 1;
        String originalMessage = "hello";
        String encryptedMessage = encrypt(originalMessage, key);
        String decryptedMessage = decrypt(encryptedMessage, key);

        System.out.println("Original Message: " + originalMessage);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}

public class BruteForce {
    private static final char[] ALPHABET = Cipher.getAlphabet();
    private final Cipher cipher = new Cipher();

    public String decryptByBruteForce(String encryptedText) {
        for (int key = 1; key < ALPHABET.length; key++) {
            String decrypted = cipher.decrypt(encryptedText, key);
            if (decrypted.contains(" ") && decrypted.toLowerCase().contains("что")) {
                return decrypted;
            }
        }
        return cipher.decrypt(encryptedText, 1);
    }
}
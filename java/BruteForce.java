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
    private static final String[] RUSSIAN_WORDS = {
            "что", "это", "и", "в", "на", "с", "по", "к", "у", "за",
            "из", "о", "от", "для", "как", "так", "все", "было", "его",
            "она", "они", "мы", "вы", "ты"
    };

    private boolean looksLikeRussian(String text) {
        String lowerText = text.toLowerCase();
        for (String word : RUSSIAN_WORDS) {
            if (lowerText.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
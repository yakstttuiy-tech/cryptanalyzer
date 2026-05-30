public class StatisticalAnalyzer {
    private static final char[] ALPHABET = Cipher.getAlphabet();
    private final Cipher cipher = new Cipher();

    public int findMostLikelyShift(String encryptedText, String representativeText) {
        char space = ' ';
        int spaceIndex = -1;
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ALPHABET[i] == space) {
                spaceIndex = i;
                break;
            }
        }

        int[] freq = new int[ALPHABET.length];
        for (int i = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            for (int j = 0; j < ALPHABET.length; j++) {
                if (ALPHABET[j] == c) {
                    freq[j]++;
                    break;
                }
            }
        }

        int maxIndex = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > freq[maxIndex]) {
                maxIndex = i;
            }
        }

        int shift = (maxIndex - spaceIndex) % ALPHABET.length;
        if (shift < 0) shift += ALPHABET.length;
        return shift;
    }
    public String analyze(String encryptedText, String representativeText) {
        System.out.println("Запуск статистического анализа...");
        int shift = findMostLikelyShift(encryptedText, representativeText);
        System.out.println("Подобран сдвиг: " + shift);
        return cipher.decrypt(encryptedText, shift);
    }
}
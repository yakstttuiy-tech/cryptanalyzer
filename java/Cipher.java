public class Cipher {
    private static final char[] ALPHABET = {
        'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м',
        'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ',
        'ы', 'ь', 'э', 'ю', 'я'
    };
    public static char[] getAlphabet() {
        return ALPHABET;
    }
    private char shiftCharacter(char c, int shift) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ALPHABET[i] == c) {
                int newIndex = (i + shift) % ALPHABET.length;
                if (newIndex < 0) {
                    newIndex += ALPHABET.length;
                }
                return ALPHABET[newIndex];
            }
        }
        return c;
    }
    public String encrypt(String text, int shift) {
        int normalizedShift = shift % ALPHABET.length;
        if (normalizedShift < 0) {
            normalizedShift += ALPHABET.length;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(shiftCharacter(text.charAt(i), normalizedShift));
        }
        return result.toString();
    }
}

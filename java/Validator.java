import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validator {
    private final char[] alphabet;

    public Validator(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public boolean isValidKey(int key) {
        return key >= 0 && key < alphabet.length;
    }

    public boolean isFileExists(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }
}

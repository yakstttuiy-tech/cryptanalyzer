import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cipher cipher = new Cipher();
        FileManager fileManager = new FileManager();
        BruteForce bruteForce = new BruteForce();
        StatisticalAnalyzer statisticalAnalyzer = new StatisticalAnalyzer();
        Validator validator = new Validator(Cipher.getAlphabet());

        while (true) {
            System.out.println("\nШифр Цезаря ");
            System.out.println("1. Шифровать файл");
            System.out.println("2. Расшифровать файл");
            System.out.println("3. Взлом перебором");
            System.out.println("4. Взлом статистическим анализом");
            System.out.println("0. Выход");
            System.out.print("Выберите режим: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("До свидания!");
                break;
            }
            if (choice < 1 || choice > 4) {
                System.out.println("Неверный выбор");
                continue;
            }
            System.out.print("Введите путь к входному файлу: ");
            String inputPath = scanner.nextLine();
            System.out.print("Введите путь к выходному файлу: ");
            String outputPath = scanner.nextLine();

            if (!validator.isFileExists(inputPath)) {
                System.out.println("Ошибка: входной файл не существует!");
                continue;
            }

            if (choice == 1 || choice == 2) {
                System.out.print("Введите ключ (сдвиг): ");
                int key = scanner.nextInt();
                scanner.nextLine();
                if (!validator.isValidKey(key)) {
                    System.out.println("Ошибка: ключ должен быть от 0 до " + (Cipher.getAlphabet().length - 1));
                    continue;
                }
                try {
                    String text = fileManager.readFile(inputPath);
                    String result;

                    if (choice == 1) {
                        result = cipher.encrypt(text, key);
                        System.out.println("Шифрование выполнено!");
                    } else {
                        result = cipher.decrypt(text, key);
                        System.out.println("Расшифровка выполнена!");
                    }
                    else if (choice == 3) {
                        result = bruteForce.decryptByBruteForce(text);
                        System.out.println("Взлом перебором выполнен!");
                    }
                    else if (choice == 4) {
                        result = statisticalAnalyzer.analyze(text, "");
                        System.out.println("Статистический анализ выполнен!");
                    }

                    fileManager.writeFile(outputPath, result);
                    System.out.println("Результат сохранён в: " + outputPath);

                } catch (java.io.IOException e) {
                    System.out.println("Ошибка ввода-вывода: " + e.getMessage());

                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }
        scanner.close();


        }
    }
}

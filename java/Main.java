import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cipher cipher = new Cipher();
        FileManager fileManager = new FileManager();
        BruteForce bruteForce = new BruteForce();
        StatisticalAnalyzer statisticalAnalyzer = new StatisticalAnalyzer();

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


        }
    }
}

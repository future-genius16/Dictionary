import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Доброго времени суток! Давайте посчитаем количество каждой буквы в Вашем тексте:)");
        System.out.print("Введите имя файла с текстом (включая формат .txt): ");
        String inputFile = scanner.nextLine();
        System.out.print("Введите имя файла, куда сохранить результаты (включая формат .txt): ");
        String outputFile = scanner.nextLine();

        Map<Character, Integer> charCount = new HashMap<>();
        try {
            File input = new File(inputFile);
            Scanner fileScanner = new Scanner(input);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                    }
                }
            }
            PrintWriter writer = new PrintWriter(outputFile);
            for (char c = 'a'; c <= 'z'; c++) {
                writer.println(c + " - " + charCount.getOrDefault(c, 0));
            }
            for (char c = 'A'; c <= 'Z'; c++) {
                writer.println(c + " - " + charCount.getOrDefault(c, 0));
            }
            writer.close();
            System.out.println("Результаты записаны в файл: " + outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден. Проверьте имя файла и попробуйте снова.");
        }
    }
}

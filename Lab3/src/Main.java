import java.util.List;

public class Main {
    public static void main(String[] args) {
        TextProc processor = new TextProc();

        try {
            String text = processor.readTextFromConsole();

            if (text.isEmpty()) {
                System.out.println("Текст не был введен.");
                return;
            }

            int wordCount = processor.countWordsWithVowelStartAndEnd(text);
            processor.printResults(text, wordCount);

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
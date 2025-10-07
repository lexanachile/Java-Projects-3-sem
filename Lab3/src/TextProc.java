import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class TextProc {
    private static final Set<Character> VOWELS = Set.of(
            'a', 'e', 'i', 'o', 'u', 'y',
            'A', 'E', 'I', 'O', 'U', 'Y',
            'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я',
            'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я'
    );

    public String readTextFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите текст (для завершения ввода нажмите Enter дважды):");
        System.out.println("----------------------------------------------------------");

        StringBuilder textBuilder = new StringBuilder();
        String line;
        int emptyLineCount = 0;

        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                emptyLineCount++;
                if (emptyLineCount >= 1) {
                    break;
                }
            } else {
                emptyLineCount = 0;
                textBuilder.append(line).append("\n");
            }
        }

        return textBuilder.toString().trim();
    }

    public int countWordsWithVowelStartAndEnd(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int count = 0;
        StringTokenizer tokenizer = new StringTokenizer(text, " \t\n\r,.;!?()[]{}«»\"'");

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().trim();
            if (isWordStartingAndEndingWithVowel(word)) {
                count++;
            }
        }

        return count;
    }

    private boolean isWordStartingAndEndingWithVowel(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);

        return VOWELS.contains(firstChar) && VOWELS.contains(lastChar);
    }

    public void printResults(String text, int wordCount) {
        System.out.println("\n==========================================");
        System.out.println("РЕЗУЛЬТАТЫ АНАЛИЗА СЛОВ ТЕКСТА");
        System.out.println("==========================================");

        System.out.println("Введенный текст:");
        System.out.println(text);

        System.out.println("\nСлов, начинающихся и заканчивающихся на гласные: " + wordCount);
        System.out.println("==========================================");
    }
}
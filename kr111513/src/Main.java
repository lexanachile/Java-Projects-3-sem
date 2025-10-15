import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String P = scanner.next();
        scanner.close();

        Set<String> results = new HashSet<>();
        int totalSum = 0;
        for (char c : P.toCharArray()) {
            totalSum += Character.getNumericValue(c);
        }

        for (int i = 0; i < P.length(); i++) {
            int currentDigit = P.charAt(i) - '0';
            for (int newDigit = 0; newDigit <= 9; newDigit++) {
                if (i == 0 && newDigit == 0 || newDigit == currentDigit) continue;

                int newSum = totalSum - currentDigit + newDigit;
                if (newSum % 9 == 0) {
                    String newNumber = P.substring(0, i) + newDigit + P.substring(i + 1);
                    results.add(newNumber);
                }
            }
        }

        for (String res : results) {
            System.out.println(res);
        }
    }
}
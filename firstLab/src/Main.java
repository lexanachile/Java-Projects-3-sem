import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    private static final double maxx = 700.0;
    private static final double minx = -700.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Напишите ex, sin или exit для подсчета функции ex, синуса или выхода соответственно");
            String selected = scanner.next();
            if (selected.equals("exit")) {
                System.out.println("Выход из программы.");
                scanner.close();
                break;
            }
            if(!selected.equals("sin") && !selected.equals("ex")) {
                System.out.println("Неизвестная команда.");
                continue;
            }
            System.out.print("Введите значение x (от " + minx + " до " + maxx + "): ");
            double inputValue = scanner.nextDouble();
            if (Double.isNaN(inputValue) || inputValue < minx || inputValue > maxx) {
                System.out.println("Ошибка: значение x выходит за допустимые пределы.");
                continue;
            }
            System.out.print("Введите количество знаков после запятой (0–15): ");
            int precision = scanner.nextInt();
            if (precision < 0 || precision > 15) {
                System.out.println("Ошибка: количество знаков должно быть от 0 до 15.");
                continue;
            }

            NumberFormat formatter = NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(precision);

            ExArray exArray = new ExArray(inputValue, precision);

            if (selected.equals("ex")) {
                double result = exArray.calculateEx();
                System.out.println("Значение exp(x): " + formatter.format(Math.exp(inputValue)));
                System.out.println("Значение ряда Тейлора: " + formatter.format(result));
            } else {
                double result = exArray.calculateSinX();
                System.out.println("Значение sin(x): " + formatter.format(Math.sin(inputValue)));
                System.out.println("Значение ряда Тейлора: " + formatter.format(result));
        }
    }
}
}

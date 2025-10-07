package lab.matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.String;
import java.util.Scanner;
import java.util.*;

public class MyArray {
    private int[][] matrix;
    private int rows, cols;

    public MyArray(String filename) throws FileNotFoundException {
        readFromFile(filename);
    }
    public void changeMatrix(String filename) throws FileNotFoundException {
        readFromFile(filename);
    }
    public void readFromFile(String filename) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            int newRows = scanner.nextInt();
            int newCols = scanner.nextInt();
            int[][] newMatrix = new int[newRows][newCols];
            for (int i = 0; i < newRows; i++) {
                for (int j = 0; j < newCols; j++) {
                    newMatrix[i][j] = scanner.nextInt();
                }
            }
            this.rows = newRows;
            this.cols = newCols;
            this.matrix = newMatrix;
        }
    }
    public void writeToFile(String filename) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    writer.print(matrix[i][j] + " ");
                }
                writer.println();
            }
        }
    }
    public void consolePrintMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int task13(){
        //13. Найти максимальное из чисел, встречающихся
        // в заданной матрице более одного раза.

        int maxNumber = -10000;
        Set<Integer> mySet = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int number = matrix[i][j];
                if(mySet.contains(number)){
                    if(number > maxNumber) maxNumber = number;
                }
                else mySet.add(number);
            }
        }
        return maxNumber;
    }

    public int task27() {
        // 27. Две строки матрицы назовем похожими, если совпадают множества чисел,
        // встречающихся в этих строках. Найти количество строк в максимальном
        // множестве попарно непохожих строк заданной матрицы.

        Map<Set<Integer>, Integer> setCounts = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                rowSet.add(matrix[i][j]);
            }
            setCounts.put(rowSet, setCounts.getOrDefault(rowSet, 0) + 1);
        }

//        int maxCount = 0;
//        for (int count : setCounts.values()) {
//            if (count > maxCount) {
//                maxCount = count;
//            }
//        }
//        return maxCount;

        return setCounts.size();
    }

    public void task41() {
        // 41. Характеристикой строки целочисленной матрицы назовем сумму
        // ее положительных четных элементов. Переставляя строки заданной
        // матрицы, расположить их в соответствии с ростом характеристик.

        int[][] characteristics = new int[rows][2];

        for (int i = 0; i < rows; i++) {
            int sumOfRow = 0;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > 0 && matrix[i][j] % 2 == 0) {
                    sumOfRow += matrix[i][j];
                }
            }
            characteristics[i][0] = i;
            characteristics[i][1] = sumOfRow;
        }

        Arrays.sort(characteristics, (a, b) -> Integer.compare(a[1], b[1]));

        int[][] newMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int originalRowIndex = characteristics[i][0];
            System.arraycopy(matrix[originalRowIndex], 0, newMatrix[i], 0, cols);
        }

        matrix = newMatrix;

    }
}


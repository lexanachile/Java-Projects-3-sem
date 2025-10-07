package lab.matrix;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try{
            MyArray fileMatrix = new MyArray("input.txt");
            fileMatrix.consolePrintMatrix();
            System.out.println();
            fileMatrix.writeToFile("output.txt");
            int t13 = fileMatrix.task13();
            System.out.println("Result of task 13: " + t13);

            int t27 = fileMatrix.task27();
            System.out.println("Result of task 27: " + t27);

            fileMatrix.task41();


            System.out.println("Result of task 41: ");
            fileMatrix.consolePrintMatrix();

        } catch(FileNotFoundException exp){
            System.out.println("File not found");
        }
    }
}
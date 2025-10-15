import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelStorage storage = new HotelStorage();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Сортировка по городу и звёздам:");
        storage.printAllSorted();

        System.out.println("\nОтели города Москва:");
        storage.printByCity("Москва");

        System.out.println("\nОтели города Минск:");
        storage.printByCity("Минск");

        System.out.println("\nГорода с отелем БГУ:");
        storage.printCitiesByHotelName("БГУ");

        while (true) {
            System.out.println("\nВведите название Отеля для поиска отелей (или 'выход' для завершения):");
            String inputCity = scanner.nextLine().trim();

            if (inputCity.equalsIgnoreCase("выход")) {
                break;
            }

            if (inputCity.isEmpty()) {
                System.out.println("Город не может быть пустым");
                continue;
            }

            storage.printCitiesByHotelName(inputCity);
        }

        scanner.close();
        System.out.println("Программа завершена");
    }
}
import java.io.File;
import java.util.*;

public class HotelStorage {
    private List<Hotel> hotels = new ArrayList<>();

    public HotelStorage() {
        loadFromFile("hotel.txt");
    }

    public HotelStorage(String filename) {
        loadFromFile(filename);
    }

    private void loadFromFile(String filename) {
        try (Scanner sc = new Scanner(new File(filename), "UTF-8")) {
            int lineCount = 0;
            String city = null;
            String name = null;

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                lineCount++;

                switch (lineCount % 3) {
                    case 1: city = line; break;
                    case 2: name = line; break;
                    case 0:
                        try {
                            int stars = Integer.parseInt(line);
                            Hotel hotel = new Hotel(city, name, stars);
                            hotels.add(hotel);
                        } catch (NumberFormatException e) {
                            System.err.println("Ошибка в формате звёзд: " + line);
                        } catch (IllegalArgumentException e) {
                            System.err.println("Ошибка создания отеля: " + e.getMessage());
                        }
                        break;
                }
            }
            System.out.println("Загружено отелей: " + hotels.size());
        } catch (Exception e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public boolean cityExists(String city) {
        return hotels.stream()
                .anyMatch(hotel -> hotel.getCity().equalsIgnoreCase(city.trim()));
    }

    public boolean hotelExists(String hotelName) {
        return hotels.stream()
                .anyMatch(hotel -> hotel.getName().equalsIgnoreCase(hotelName.trim()));
    }

    public void printAllSorted() {
        if (hotels.isEmpty()) {
            System.out.println("Нет отелей для отображения");
            return;
        }

        hotels.stream()
                .sorted(Comparator.comparing(Hotel::getCity)
                        .thenComparing(Hotel::getStars, Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    public void printByCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            System.out.println("Город не указан");
            return;
        }

        String searchCity = city.trim();
        if (!cityExists(searchCity)) {
            System.out.println("Город '" + city + "' не найден");
            return;
        }

        hotels.stream()
                .filter(hotel -> hotel.getCity().equalsIgnoreCase(searchCity))
                .sorted(Comparator.comparing(Hotel::getStars).reversed())
                .forEach(System.out::println);
    }

    public void printCitiesByHotelName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Название отеля не указано");
            return;
        }

        String searchName = name.trim();
        if (!hotelExists(searchName)) {
            System.out.println("Отель с названием '" + name + "' не найден");
            return;
        }

        hotels.stream()
                .filter(hotel -> hotel.getName().equalsIgnoreCase(searchName))
                .map(Hotel::getCity)
                .distinct()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach(System.out::println);
    }
}
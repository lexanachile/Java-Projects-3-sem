public class Hotel {
    private String city;
    private String name;
    private int stars;

    public Hotel() {
        this.city = "Неизвестно";
        this.name = "Неизвестно";
        this.stars = 2;
    }

    public Hotel(String city, String name, int stars) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("Город не может быть пустым");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название отеля не может быть пустым");
        }
        if (stars < 2 || stars > 4) {
            throw new IllegalArgumentException("Количество звёзд должно быть от 2 до 4");
        }
        this.city = city.trim();
        this.name = name.trim();
        this.stars = stars;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    @Override
    public String toString() {
        return city + " " + name + " " + stars + "★";
    }
}
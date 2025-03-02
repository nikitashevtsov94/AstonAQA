public class Product {
    private String name;
    private String date;
    private String manufacturer;
    private String countryOfManuf;
    private double price;
    private boolean bookingState;

    public Product(String name, String date, String manufacturer, String countryOfManuf, double price, boolean bookingState) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.countryOfManuf = countryOfManuf;
        this.price = price;
        this.bookingState = bookingState;
    }

    public void getProductInfo() {
        System.out.printf("Название: %s;%nДата производства: %s;%nПроизводитель: %s;%nСтрана производства: %s;%nЦена: %.2f;%nСтатус бронирования покупателем: %b.%n", name, date, manufacturer, countryOfManuf, price, bookingState);
    }
}
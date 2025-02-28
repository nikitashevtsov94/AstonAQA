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

    public static void main(String[] args) {
        Product firstProd = new Product("Samsung", "01.01.2015", "Samsung Corp.", "Korea", 599.99, true);
        firstProd.getProductInfo();
    }

    public void getProductInfo() {
        System.out.print(String.format("Название: %s;%nДата производства: %s;%nПроизводитель: %s;%nСтрана производства: %s;%nЦена: %.2f;%nСтатус бронирования покупателем: %s.%n", this.name, this.date, this.manufacturer, this.countryOfManuf, this.price, this.bookingState));
    }
}
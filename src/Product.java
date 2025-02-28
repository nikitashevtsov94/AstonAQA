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

        //Task1
        Product firstProd = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 599.99, true);
        firstProd.getProductInfo();

        //Task2
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("HTC", "01.05.2005", "HTC Corp.", "Taiwan", 349.99, false);
        productsArray[1] = new Product("Apple iPhone 15", "01.09.2024", "Apple inc.", "USA", 799.99, true);
        productsArray[2] = new Product("Poco F5", "15.05.2022", "Xiaomi inc.", "China", 589.99, true);
        productsArray[3] = new Product("Xiaomi 14 Pro", "27.02.2023", "Xiaomi inc.", "China", 899.99, false);
        productsArray[4] = new Product("Google Pixel 9 Pro", "01.10.2024", "Google inc.", "USA", 899.99, true);
    }

    public void getProductInfo() {
        System.out.print(String.format("Название: %s;%nДата производства: %s;%nПроизводитель: %s;%nСтрана производства: %s;%nЦена: %.2f;%nСтатус бронирования покупателем: %b.%n", name, date, manufacturer, countryOfManuf, price, bookingState));
    }
}
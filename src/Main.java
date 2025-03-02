public class Main {

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

        //Task3
        Park park = new Park("Gor'kij", "Minsk");
        park.createRide("Rakushki", "10.00-20.00", 5);
        park.createRide("Lad'ya", "10.00-20.00", 6);
        park.createRide("Avtodrom", "11.00-19.00", 8);
        park.getParkInfo();
    }
}

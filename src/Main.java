public class Main {

    public static void main(String[] args) {
        Park park = new Park("Gor'kij", "Minsk");
        park.createRide("Rakushki", "10.00-20.00", 5);
        park.createRide("Lad'ya", "10.00-20.00", 6);
        park.createRide("Avtodrom", "11.00-19.00", 8);
        park.getParkInfo();
    }
}

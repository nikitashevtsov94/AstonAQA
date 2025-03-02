public class Main {

    public static void main(String[] args) {
        Park park = new Park("Gor'kij", "Minsk");
        Park.Rides ride = park.createRide("Rakushki", "10.00-20.00", 5);
        park.getParkInfo();
        ride.getRideInfo();
    }

}

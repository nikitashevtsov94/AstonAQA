public class Park {
    private String parkName;
    private String location;
    private Rides ride;
    private static int rideCount = 0;

    public Park(String parkName, String location) {
        this.parkName = parkName;
        this.location = location;

    }
    public void getParkInfo() {
        System.out.printf("Название парка: %s;%nМестоположение парка: %s;%nКоличество аттракционов: %s.%n", parkName, location, rideCount);
    }

    public Rides createRide(String rideName, String workingTime, int cost) {
        ride = new Rides(rideName, workingTime, cost);
        System.out.printf("Создан аттракцион %s.%n", rideName);
        rideCount++;
        return ride;
    }

    public class Rides {
        private String rideName;
        private String workingTime;
        private int cost;

        public Rides(String rideName, String workingTime, int cost) {
            this.rideName = rideName;
            this.workingTime = workingTime;
            this.cost = cost;
        }

         public void getRideInfo() {
             System.out.printf("Название атракциона: %s;%nВремя работы: %s;%nСтоимость катания: %s бел. руб.%n", rideName, workingTime, cost);
         }
    }
}
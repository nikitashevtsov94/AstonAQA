public class Park {
    private String parkName;
    private String location;
    private static int rideCount = 0;
    private static Rides[] numberOfRides = new Rides[4];

    public Park(String parkName, String location) {
        this.parkName = parkName;
        this.location = location;

    }
    public void getParkInfo() {
        System.out.printf("Название парка: %s;%nМестоположение парка: %s;%nКоличество аттракционов: %s.%n", parkName, location, rideCount);
        for (int i = 0; i < numberOfRides.length; i++) {
            if (numberOfRides[i] != null) {
                numberOfRides[i].getRideInfo();
            } else {
                break;
            }
        }
    }

    public void createRide(String rideName, String workingTime, int cost) {
        rideCount++;
        Rides ride;
        if (rideCount > numberOfRides.length) {
            System.out.println("Площадь парка не расчитана на данное количество аттракционов");
        } else {
            ride = new Rides(rideName, workingTime, cost);
            numberOfRides[rideCount - 1] = ride;
            System.out.printf("Создан аттракцион %s.%n", rideName);
        }
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
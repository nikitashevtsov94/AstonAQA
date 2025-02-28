public class Park {
    private String name;
    private String location;

    public class Rides {
        private String name;
        private String workingTime;
        private int cost;

        public Rides(String name, String workingTime, int cost) {
            this.name = name;
            this.workingTime = workingTime;
            this.cost = cost;
        }
    }
}

public abstract class Animals {
    private String name;

    public static int animalCount = 0;

    public Animals(String name) {
        this.name = name;
        animalCount++;
    }
    public abstract void run(int runDist);

    public abstract void swim(int swimDist);

    public abstract int eat(int amountOfFood);

    public static void getAnimalsCount() {
        System.out.println(animalCount);
    }

    public String getName() {
        return name;
    }




}

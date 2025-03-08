package zoo;

public abstract class Animals {

    private final String name;
    private final String color;

    private static int animalsCount = 0;

    protected Animals(String name, String color) {
        this.name = name;
        this.color = color;
        animalsCount++;
    }

    public abstract void run(int runDist);

    public abstract void swim(int swimDist);

    public abstract int eat(int amountOfFood);

    public static void getAnimalsCount() {
        System.out.println("Количество всех животный: " + animalsCount);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}

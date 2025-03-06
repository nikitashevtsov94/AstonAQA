public class Dog extends Animals {
    private static int dogsCount = 0;

    public Dog(String name, String color) {
        super(name, color);
        System.out.printf("Прибежала %s собака %s.%n", getColor(), getName());
        dogsCount++;
    }

    @Override
    public void run(int runDist) {
        if(runDist > 0 && runDist <= 500) {
            System.out.printf("%s собака %s пробежала %d м.%n", getColor(), getName(), runDist);
        }
        else {
            System.out.printf("%s собака %s пробежала 500 метров и упала без сил.%n", getColor(), getName());
        }
    }

    @Override
    public void swim(int swimDist) {
        if(swimDist > 0 && swimDist <= 10) {
            System.out.printf("Собака %s с удовольствие прыгнула в воду и проплыла %d м.%n", getName(), swimDist);
        }
        else {
            System.out.printf("%s собака %s почуял, что не проплывет больше 10 м и вернулась на берег.%n", getColor(), getName());
        }
    }

    @Override
    public int eat(int amountOfFood) {
        return amountOfFood;
        }


    public static void getDogsCount() {
        System.out.println("Количество всех собак: " + dogsCount);
    }

}

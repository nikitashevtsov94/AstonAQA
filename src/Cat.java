public class Cat extends Animals {
    private static int catCount = 0;
    private String color;
    private boolean satiety = false;
    private int levelOfSatiety;

    public String getColor() {
        return color;
    }

    public Cat(String name, String color, int levelOfSatiety) {
        super(name);
        this.color = color;
        if (levelOfSatiety < 0) {
            this.levelOfSatiety = 1;
            System.out.println("Чувство насыщения кота не может быть отрицательным. Поэтому этот кот будет есть совсем немного");
        } else {
            this.levelOfSatiety = levelOfSatiety;
            System.out.printf("Прибежал %s кот %s. Кажется, он голоден.%n", getColor(), getName());
        }
        catCount++;
    }

    @Override
    public void run(int runDist) {
        if(runDist > 0 && runDist <= 200) {
            System.out.printf("Кот %s пробежал %d%n", getName(), runDist);
        }
        else {
            System.out.printf("%s кот %s пробежал 200 метров и упал без сил.%n", getColor(), getName());
        }
    }

    @Override
    public void swim(int swimDist) {
        System.out.printf("Кот %s шипит на воду. Сегодня плавать он не собирался.%n", getName());
    }

    public static void getCatsCount() {
        System.out.println(catCount);
    }

    public boolean getSatiety() {
        return satiety;
    }

    public int getLevelOfSatiety() {
        return levelOfSatiety;
    }

    @Override
    public int eat(int amountOfFood) {
        if(amountOfFood >= this.levelOfSatiety) {
            System.out.printf("Кот %s наелся.%n", getName());
            this.satiety = true;
            amountOfFood = amountOfFood - this.levelOfSatiety;
            return amountOfFood;
        } else {
            System.out.printf("Коту %s недостаточно еды, чтобы стать сытым.%n", getName());
            return amountOfFood;
        }
    }



}

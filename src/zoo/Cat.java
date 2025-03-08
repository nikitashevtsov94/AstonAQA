package zoo;

public class Cat extends Animals {
    private static int catsCount = 0;
    private boolean satiety = false;
    private int levelOfSatiety;


    public Cat(String name, String color, int levelOfSatiety) {
        super(name, color);
        if (levelOfSatiety < 0) {
            this.levelOfSatiety = 1;
            System.out.println("Чувство насыщения кота не может быть отрицательным. Поэтому этот кот будет есть совсем немного");
        } else {
            this.levelOfSatiety = levelOfSatiety;
            System.out.printf("Прибежал %s кот %s. Кажется, он голоден.%n", getColor(), getName());
        }
        catsCount++;
    }

    @Override
    public void run(int runDist) {
        if(runDist > 0 && runDist <= 200) {
            System.out.printf("Кот %s пробежал %d м.%n", getName(), runDist);
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
        System.out.println("Количество всех котов: " + catsCount);
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
            this.satiety = true;
            System.out.printf("Кот %s наелся(%b).%n", getName(), satiety);
            amountOfFood = amountOfFood - this.levelOfSatiety;
            return amountOfFood;
        } else {
            System.out.printf("Коту %s недостаточно еды, чтобы стать сытым(%b).%n", getName(), satiety);
            return amountOfFood;
        }
    }



}

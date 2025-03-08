import figures.Circle;
import figures.Rectangle;
import figures.Triangle;
import zoo.Animals;
import zoo.Bowl;
import zoo.Cat;
import zoo.Dog;

public class Main {
    public static void main(String[] args) {
        //Task1
        Animals catVasya = new Cat("Вася", "Серый", 8);
        Animals catChip = new Cat("Чип", "Черно-белый", 13);
        Animals dogBim = new Dog("Бим", "Черная");
        Animals dogBarbos = new Dog("Барбос", "Золотистая");

        catVasya.run(205);
        catVasya.swim(10);

        catChip.run(10);
        catChip.swim(11);

        dogBim.run(300);
        dogBim.swim(6);

        dogBarbos.run(600);
        dogBarbos.swim(20);

        Bowl bowl = new Bowl(150);
        int amountOfFood = bowl.addFoodInBowl(20);
        Cat[] flockOfCats = new Cat[4];
        flockOfCats[0] = new Cat("Барсик", "Черный", 12);
        flockOfCats[1] = new Cat("Киндер", "Белый", 15);
        flockOfCats[2] = new Cat("Персик", "Рыжий", 5);
        flockOfCats[3] = new Cat("Бублик", "Полосатый", 12);
        for (int i = 0; i < flockOfCats.length; i++) {
            int foodBalance = flockOfCats[i].eat(amountOfFood);
            amountOfFood = foodBalance;
        }
        System.out.printf("В миске осталось %s гр. еды.%n", amountOfFood);

        Animals.getAnimalsCount();
        Cat.getCatsCount();
        Dog.getDogsCount();

        //Task 2
        Triangle abc = new Triangle(3.0, 6.0, 4.0, 5.0, "Красный", "Зеленый");
        double trP = abc.calculateTrPerimeter(abc.getSideA(), abc.getSideB(), abc.getSideC());
        double trS = abc.calculateTrArea();
        abc.getTriangleInfo(trP, trS);

        Rectangle abcd = new Rectangle(3.0, 5.0, "Синий", "Желтый");
        double recP = abcd.calculateRecPerimeter(abcd.getSideA(), abcd.getSideB());
        double recS = abcd.calculateRecArea();
        abcd.getRectangleInfo(recP, recS);

        Circle circle = new Circle(6.0, "Белый", "Бордовый");
        double circP = circle.calculateCirclePerimeter(circle.getRadius());
        double circS = circle.calculateCircleArea();
        circle.getCircleInfo(circP, circS);
    }
}

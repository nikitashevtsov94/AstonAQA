import figures.Circle;
import figures.Rectangle;
import figures.Triangle;

public class Main {
    public static void main(String[] args) {
        /*zoo.Animals catVasya = new zoo.Cat("Вася", "Серый", 8);
        zoo.Animals catChip = new zoo.Cat("Чип", "Черно-белый", 13);
        zoo.Animals dogBim = new zoo.Dog("Бим", "Черная");
        zoo.Animals dogBarbos = new zoo.Dog("Барбос", "Золотистая");

        catVasya.run(205);
        catVasya.swim(10);

        catChip.run(10);
        catChip.swim(11);

        dogBim.run(300);
        dogBim.swim(6);

        dogBarbos.run(600);
        dogBarbos.swim(20);

        zoo.Bowl bowl = new zoo.Bowl(150);
        int anountOfFood = bowl.addFoodInBowl(20);
        zoo.Cat[] flockOfCats = new zoo.Cat[4];
        flockOfCats[0] = new zoo.Cat("Барсик", "Черный", 12);
        flockOfCats[1] = new zoo.Cat("Киндер", "Белый", 15);
        flockOfCats[2] = new zoo.Cat("Персик", "Рыжий", 5);
        flockOfCats[3] = new zoo.Cat("Бублик", "Полосатый", 12);
            for (int i = 0; i < flockOfCats.length; i++) {
                int foodBalance = flockOfCats[i].eat(anountOfFood);
                anountOfFood = foodBalance;
            }
        System.out.printf("В миске осталось %s гр. еды.%n", anountOfFood);

        zoo.Animals.getAnimalsCount();
        zoo.Cat.getCatsCount();
        zoo.Dog.getDogsCount();

         */
        //Task 2
        Triangle abc = new Triangle(3.0, 6.0, 4.0, 5.0, "Красный", "Зеленый");
        double trP = abc.calculateTrPerimeter(abc.getA(), abc.getB(), abc.getC());
        double trS = abc.calculateTrArea();
        abc.getTriangleInfo(trP, trS);

        Rectangle abcd = new Rectangle(3.0, 5.0, "Синий", "Желтый");
        double recP = abcd.calculateRecPerimeter(abcd.getA(), abcd.getB());
        double recS = abcd.calculateRecArea();
        abcd.getRectangleInfo(recP, recS);

        Circle circle = new Circle(6.0, "Белый", "Бордовый");
        double circP = circle.calculateCircPerimeter(circle.getA());
        double circS = circle.calculateCircArea();
        circle.getCircleInfo(circP, circS);

    }
}

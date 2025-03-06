public class Main {
    public static void main(String[] args) {
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
        int anountOfFood = bowl.addFoodInBowl(20);
        Cat[] flockOfCats = new Cat[4];
        flockOfCats[0] = new Cat("Барсик", "Черный", 12);
        flockOfCats[1] = new Cat("Киндер", "Белый", 15);
        flockOfCats[2] = new Cat("Персик", "Рыжий", 5);
        flockOfCats[3] = new Cat("Бублик", "Полосатый", 12);
            for (int i = 0; i < flockOfCats.length; i++) {
                int foodBalance = flockOfCats[i].eat(anountOfFood);
                anountOfFood = foodBalance;
            }
        System.out.printf("В миске осталось %s гр. еды.%n", anountOfFood);

        Animals.getAnimalsCount();
        Cat.getCatsCount();
        Dog.getDogsCount();

    }
}

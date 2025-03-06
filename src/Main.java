public class Main {
    public static void main(String[] args) {
    Animals catPups = new Cat("Пупсик", "Рыжий", 150);
    /* Animals dogBim = new Dog("Бим", "Черная");
        catPups.run(205);
        catPups.swim(0);
        dogBim.run(300);
        dogBim.swim(6);
        Animals.getAnimalsCount();
        Cat.getCatsCount();
        Dog.getDogsCount();
     */
    Bowl bowl = new Bowl(150);
    int volume = bowl.addFoodInBowl(140);
    volume = catPups.eat(volume);
    System.out.println(volume);

    }
}

public class Bowl {
    private int bowlVolume;

    public Bowl() {

    }

    public Bowl(int bowlVolume) {
        this.bowlVolume = bowlVolume;
        System.out.printf("Поставили миску объемом %d гр.%n", bowlVolume);
    }

    public int getBowlVolume() {
        return bowlVolume;
    }

    public void setBowlVolume(int bowlVolume) {
        this.bowlVolume = bowlVolume;
    }
    public int addFoodInBowl(int foodVolume) {
        if(foodVolume > 0 && foodVolume <= bowlVolume) {
            System.out.printf("В миску насыпали %d гр. еды%n", foodVolume);
            return foodVolume;
        } else {
            System.out.println("В миску нельзя положить столько еды, пожтому она пуста. Присмотрись к объему миски");
            return 0;
        }

    }

}

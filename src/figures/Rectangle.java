package figures;

public class Rectangle extends Figure implements RectangleOperations {
    private double sideA;
    private double sideB;

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public Rectangle(double sideA, double sideB, String borderColor, String innerColor) {
        super(borderColor, innerColor);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public void getRectangleInfo(double recP, double recS) {
        System.out.printf("Периметр прямоугольника = %.2f, Площадь прямоугольника = %.2f, Цвет границы: %s, Цвет заливки: %s.%n",
                recP, recS, getBorderColor(), getInnerColor());
    }

    @Override
    public double calculateRecArea() {
        return (this.sideA * this.sideB);
    }
}

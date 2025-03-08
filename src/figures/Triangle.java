package figures;

public class Triangle extends Figure implements TriangleOperations {
    private double height;
    private double sideA;
    private double sideB;
    private double sideC;

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public Triangle(double height, double sideA, double sideB, double sideC, String borderColor, String innerColor) {
        super(borderColor, innerColor);
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public void getTriangleInfo(double trP, double trS) {
        System.out.printf("Периметр треугольника = %.2f, Площадь треугольника = %.2f, Цвет границы: %s, Цвет заливки: %s.%n",
                trP, trS, getBorderColor(), getInnerColor());
    }

    @Override
    public double calculateTrArea() {
        return 0.5 * (this.height * this.sideA);
    }
}

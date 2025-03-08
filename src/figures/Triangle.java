package figures;

public class Triangle implements TriangleOperations {
    private double h;
    private double a;
    private double b;
    private double c;
    private String borderColor;
    private String innerColor;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getH() {
        return h;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public String getInnerColor() {
        return innerColor;
    }

    public void setInnerColor(String innerColor) {
        this.innerColor = innerColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public Triangle(double h, double a, double b, double c, String borderColor, String innerColor) {
        this.h = h;
        this.a = a;
        this.b = b;
        this.c = c;
        this.borderColor = borderColor;
        this.innerColor = innerColor;
    }

    public void getTriangleInfo(double trP, double trS) {
        System.out.printf("Периметр треугольника = %.2f, Площадь треугольника = %.2f, Цвет границы: %s, Цвет заливки: %s.%n",
                trP, trS, getBorderColor(), getInnerColor());
    }

    @Override
    public double calculateTrArea() {
        return 0.5 * (this.h * this.a);
    }





}

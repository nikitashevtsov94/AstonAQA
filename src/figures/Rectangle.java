package figures;

public class Rectangle implements RectangleOperations {
    private double a;
    private double b;
    private String borderColor;
    private String innerColor;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
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

    public Rectangle(double a, double b, String borderColor, String innerColor) {
        this.a = a;
        this.b = b;
        this.borderColor = borderColor;
        this.innerColor = innerColor;
    }

    public void getRectangleInfo(double recP, double recS) {
        System.out.printf("Периметр прямоугольника = %.2f, Площадь прямоугольника = %.2f, Цвет границы: %s, Цвет заливки: %s.%n",
                recP, recS, getBorderColor(), getInnerColor());
    }

    @Override
    public double calculateRecArea() {
        return (this.a * this.b);
    }
}

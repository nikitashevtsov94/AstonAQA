package figures;

public class Circle extends Figure implements CircleOperations {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String borderColor, String innerColor) {
        super(borderColor, innerColor);
        this.radius = radius;
    }

    public void getCircleInfo(double circP, double circS) {
        System.out.printf("Периметр круга = %.2f, Площадь круга = %.2f, Цвет границы: %s, Цвет заливки: %s.%n",
                circP, circS, getBorderColor(), getInnerColor());
    }

    @Override
    public double calculateCircleArea() {
        return (Math.pow(this.radius, 2) * Math.PI);
    }
}

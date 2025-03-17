package application;

public class Triangle {
    private double sideLength;
    private double highLength;

    public Triangle(double sideLength, double highLength) {
        this.sideLength = sideLength;
        this.highLength = highLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getHighLength() {
        return highLength;
    }

    public void setHighLength(double highLength) {
        this.highLength = highLength;
    }

    public double calculateArea(double sideLength, double highLength) throws InvalideTriangleException {
        this.sideLength = sideLength;
        this.highLength = highLength;
        if (highLength > sideLength || highLength <= 0 || sideLength <= 0) {
            throw new InvalideTriangleException("Такой треугольник не может существовать");
        }
        return 0.5 * sideLength * highLength;
    }
}

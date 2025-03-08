package figures;

public interface CircleOperations {
    default double calculateCirclePerimeter(double r) {
        return 2 * Math.PI * r;
    }

    double calculateCircleArea();
}

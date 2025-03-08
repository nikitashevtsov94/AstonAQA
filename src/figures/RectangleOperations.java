package figures;

public interface RectangleOperations {
    default double calculateRecPerimeter(double a, double b) {
        return 2 * (a + b);
    }

    double calculateRecArea();
}

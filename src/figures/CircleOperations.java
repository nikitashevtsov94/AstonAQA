package figures;

public interface CircleOperations {
    double PI =  Math.PI;
    default double calculateCircPerimeter(double r) {
        return 2 * PI * r;
    }
    double calculateCircArea();
}

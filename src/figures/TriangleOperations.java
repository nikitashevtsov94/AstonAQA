package figures;

public interface TriangleOperations {
    default double calculateTrPerimeter(double a, double b, double c) {
     return a + b + c;
    }
    double calculateTrArea();

}

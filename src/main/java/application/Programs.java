package application;

public class Programs {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(5.00, 6.00);
        try {
            System.out.println(Factorial.calculateFactorial(-2));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(triangle.calculateArea(5.00, 6.00));
        } catch (InvalideTriangleException e) {
            System.out.println(e.getMessage());
        }
        try {
        System.out.println(CalculatorLite.calculateDivision(1, 0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(NumberComparator.compareNumbers(0,0));

    }










}

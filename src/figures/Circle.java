package figures;

public class Circle implements CircleOperations{
        private double r;
        private static final double PI = Math.PI;
        private String borderColor;
        private String innerColor;

        public double getA() {
            return r;
        }

        public void setA(double r) {
            this.r = r;
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

        public Circle(double r, String borderColor, String innerColor) {
            this.r = r;
            this.borderColor = borderColor;
            this.innerColor = innerColor;
        }

        public void getCircleInfo(double circP, double circS) {
            System.out.printf("Периметр круга = %.2f, Площадь круга = %.2f, Цвет границы: %s, Цвет заливки: %s.%n",
                    circP, circS, getBorderColor(), getInnerColor());
        }

        @Override
        public double calculateCircArea() {
            return (Math.pow(this.r, 2) * PI);
        }
}

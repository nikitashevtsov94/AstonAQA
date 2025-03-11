package testException;

public class Main {
    public static void main(String[] args) {
        String[][] stringArray = {
                {"4", "5", "1", "2"},
                {"2", "2", "1", "4"},
                {"1", "2", "c", "1"},
                {"5", "1", "3", "5"}
        };
        try {
            sumElementsOfArrayFourByFour(stringArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

        //Task4
        int[] array = {1, 2, 2};
        int index = 3;
        try {
            checkArrayElement(array, index);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("Получено исключение: %s%n", e.getMessage());
        }

    }

    private static void sumElementsOfArrayFourByFour(String[][] stringArray) throws MyArraySizeException {
        if (stringArray.length != 4) {
            throw new MyArraySizeException("Размерность массива должна быть 4х4");
        }

        for (String[] strings : stringArray) {
            if (strings.length != 4) {
                throw new MyArraySizeException("Размерность массива должна быть 4х4");
            }
        }
        System.out.println("Задан массив размером 4х4");

        int summ = 0;
        int temp;
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                try {
                    temp = Integer.parseInt(stringArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Элемент %d х %d не является числом", i, j));
                }

                summ = summ + temp;
            }
        }
        System.out.println("Сумма элементов массива равна: " + summ);

    }

    private static void checkArrayElement(int [] array, int index) throws ArrayIndexOutOfBoundsException {
        if (index > array.length - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Указан индекс за пределами размерности массива");
        }
    }


}



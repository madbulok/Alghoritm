package homework.lesson2;

import homework.lesson2.exeptions.MyArrayDataException;
import homework.lesson2.exeptions.MyArraySizeException;

import java.util.Locale;

public class Main {
    private final static int SIZE_ARRAY = 4;

    public static void main(String[] args) {

        String[][] s = {{"3","2","4","4"},{"1","2","3","3а"},{"6","1","2","3"},{"1","2","3","4"}};

        try {
            checkArray(s);
            int totalSumm = summElementsArray(s);
            System.out.println("Сумма элементов массива = " + totalSumm);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage() + String.format(Locale.getDefault()," в позиции [%d:%d]", e.getRow(), e.getColumn()));
        }
    }

    private static void checkArray(String[][] arr) throws MyArraySizeException {
        if (arr.length != SIZE_ARRAY)throw new MyArraySizeException("Массив не соответствует заданному разверу: " + arr.length +" строк");
        for (int i = 0; i < SIZE_ARRAY; i++) {
            if (arr[i].length != SIZE_ARRAY)throw new MyArraySizeException("Массив не соответствует заданному разверу: " + arr[i].length +" колонок");
        }
        System.out.println("Массив соответствует заданному размеру!");
    }

    private static int summElementsArray(String[][] arr) throws MyArrayDataException {
        int total = 0;
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr.length; c++) {
                try{
                    total += Integer.parseInt(arr[r][c]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("Некорректное значение [" + arr[r][c] + "]", r, c);
                }
            }
        }
        return total;
    }
}

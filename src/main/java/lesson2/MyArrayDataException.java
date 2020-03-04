package lesson2;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j) {
        super("ВНИМАНИЕ! Произошла ошибка преобразования символов в число в строке массива "+i+" столбце "+j+".");
    }
}

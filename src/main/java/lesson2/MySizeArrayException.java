package lesson2;

public class MySizeArrayException extends NumberFormatException {
    public MySizeArrayException() {
        super("ВНИМАНИЕ!Обнаружена ошибка: Массив должен быть строго в размере 4х4.");
    }
}

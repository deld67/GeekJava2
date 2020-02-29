package lesson2;

public class homework2 {
    public static void main(String[] args) {
        String[][]  experRabbit;
        int cur_i = 4;
        int cur_j = 4;
        MyArray header = new MyArray();
        System.out.println("============ ПРИМЕР 1 ===========================");
        System.out.printf("Создаем массив %dx%d только из цифр.%n",cur_i,cur_j);
        header.setStrToInitArray(new char[]{'0','1','2','3','4','5','6','7','8','9'});
        experRabbit = header.initArray(cur_i, cur_i);
        header.printArray(experRabbit);
        System.out.printf("Cумма всех элементов массива: %d%n", header.convertAndCalcSum(experRabbit));
        System.out.println("============ ПРИМЕР 2 ===========================");
        System.out.printf("Создаем смешанный массив %dx%d из цифр и литеры 'Q'.%n",cur_i,cur_j);
        header.setStrToInitArray(new char[]{'0','1','2','3','4','5','6','7','8','9','Q'});
        experRabbit = header.initArray(cur_i, cur_i);
        header.printArray(experRabbit);
        try {
            System.out.printf("Cумма всех элементов массива: %d%n", header.convertAndCalcSum(experRabbit));
        }catch (MyArrayDataException  e){
            System.out.println(e.getMessage());
            System.out.println(e.fillInStackTrace());
        }
        System.out.println("============ ПРИМЕР 3 ===========================");
        cur_i = 5;
        cur_j = 4;
        System.out.printf("Создаем  массив %dx%d из цифр.%n",cur_i,cur_j);
        header.setStrToInitArray(new char[]{'0','1','2','3','4','5','6','7','8','9'});
        experRabbit = header.initArray(cur_i, cur_j);
        header.printArray(experRabbit);
        try {
            System.out.printf("Cумма всех элементов массива: %d%n", header.convertAndCalcSum(experRabbit));
        }catch (MyArrayDataException e){
            System.out.println(e.getMessage());
            System.out.println(e.fillInStackTrace());
        }catch (MySizeArrayException e){
            System.out.println(e.getMessage());
            System.out.println(e.fillInStackTrace());
        }
        System.out.println("============ ПРИМЕР 4 ===========================");
        cur_i = 4;
        cur_j = 5;
        System.out.printf("Создаем  массив %dx%d из цифр %n",cur_i,cur_j);
        header.setStrToInitArray(new char[]{'0','1','2','3','4','5','6','7','8','9'});
        experRabbit = header.initArray(cur_i, cur_j);
        header.printArray(experRabbit);
        try {
            System.out.printf("Cумма всех элементов массива: %d%n", header.convertAndCalcSum(experRabbit));
        }catch (MyArrayDataException e){
            System.out.println(e.getMessage());
            System.out.println(e.fillInStackTrace());
        }catch (MySizeArrayException e){
            System.out.println(e.getMessage());
            System.out.println(e.fillInStackTrace());
        }
    }
}

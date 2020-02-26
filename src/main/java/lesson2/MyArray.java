package lesson2;

import java.util.Random;

public class MyArray {
    private static final int MAX_STR_LENGTH = 3;
    private static final int MAX_ARRAY_LENGTH = 4;
    private static final int MAX_ARRAY_HEIGHT = 4;
    public char[]  strToInitArray =
            new char[]{'0','1','2','3','4','5','6','7','8','9'};//,'Q','W','E','R','T','Y','U','I','O','P'};
    public String[][] initArray(int maxi, int maxj){
        String[][] tmpArray = new String[maxi][maxj];
        for (int i = 0; i < maxi ; i++) {
            for (int j = 0; j < maxj; j++) {
                int res_len = 0;
                tmpArray[i][j] = "";
                while (res_len == 0) res_len = new Random().nextInt(MAX_STR_LENGTH);
                for (int k = 0; k < res_len ; k++) {
                    int ch_i = 0;
                    while (ch_i == 0) ch_i = new Random().nextInt(strToInitArray.length);
                    tmpArray[i][j] +=  strToInitArray[ch_i];
                }
            }
        }
        return tmpArray;
    }

    public void printArray(String[][] arrayForPrint){
        for (int i = 0; i < arrayForPrint.length; i++) {
            for (int j = 0; j < arrayForPrint[i].length; j++) {
                System.out.printf(arrayForPrint[i][j]+" ");
            }
            System.out.println();
        }

    }

    public int convertAndCalcSum(String[][] inArray){
        int sumArray = 0;
        if (inArray.length !=  MAX_ARRAY_HEIGHT){
            throw new MySizeArrayException();
        }
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i].length != MAX_ARRAY_LENGTH){
                throw new MySizeArrayException();
            }
            for (int j = 0; j < inArray[i].length; j++) {
                try {
                    sumArray += Integer.parseInt(inArray[i][j]);
                }catch (NumberFormatException  e){
                    throw new MyArrayDataException( i, j);
                }

            }
        }
        return sumArray;
    }

    public char[] getStrToInitArray() {
        return strToInitArray;
    }

    public void setStrToInitArray(char[] strToInitArray) {
        this.strToInitArray = strToInitArray;
    }
}

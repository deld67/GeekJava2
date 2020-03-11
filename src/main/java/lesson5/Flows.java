package lesson5;

public class Flows {
    static final int size = 10000000;
    static final int h = size / 2;

    public float[] InitArray(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        return arr;
    }

    public void PrintArray(float[] arr) {
        for (float el: arr ) {
            System.out.println(el);
        }

    }

    public float[]  ReCalcArray(float[] tmp_arr) {
        for (int i = 0; i < tmp_arr.length; i++) {
            tmp_arr[i] = (float)(tmp_arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return tmp_arr;
    }

    public static int getSize() {
        return size;
    }

    public static int getH() {
        return h;
    }

}

package lesson5;

public class homework5 {
    static class ThreadForCalc extends Thread{
        float[] tmp_array;

        public float[] getTmp_array() {
            return tmp_array;
        }

        public void setTmp_array(float[] tmp_array) {
            this.tmp_array = tmp_array;
        }

        @Override
        public void run() {
            Flows flow = new Flows();
            this.tmp_array = flow.ReCalcArray(this.tmp_array);
        }

    }
    public static void main(String[] args) throws InterruptedException {
        Flows flows = new Flows();
        float[] arr = new float[flows.getSize()];
        int cnt_flows = 2;
        arr =  flows.InitArray(arr);
        System.out.println("Test calculate with one flow");
        long start_time = System.currentTimeMillis();
        arr = flows.ReCalcArray(arr);
        System.out.printf("ReCalculating Array for %d millis %n",System.currentTimeMillis()-start_time);
        System.out.println("================================================");
        System.out.printf("Test calculate with %d flows%n", cnt_flows);
        arr =  flows.InitArray(arr);
         start_time = System.currentTimeMillis();
        int dobble_calc = flows.getSize()%cnt_flows;
        int calc_pos = flows.getSize()/cnt_flows;
        ThreadForCalc[] threads = new ThreadForCalc[cnt_flows];
        float[] arr_tmp = new float[calc_pos];
        for (int i = 0; i < cnt_flows; i++) {
            threads[i] = new ThreadForCalc();
            if (dobble_calc > 0 ) {
                int start_pos = i == 0? 0: i*calc_pos+1;
                System.arraycopy(arr,start_pos,arr_tmp, 0, calc_pos);
                dobble_calc --;
            }else{
                System.arraycopy(arr,i*calc_pos, arr_tmp, 0, calc_pos);
            }
            threads[i].setTmp_array(arr_tmp);
            threads[i].start();

        }
        calc_pos = 0;
        for (int i = 0; i < cnt_flows; i++) {
            threads[i].join();
            System.arraycopy(threads[i].getTmp_array(), 0, arr, calc_pos, threads[i].getTmp_array().length );
            calc_pos += threads[i].getTmp_array().length;
        }

        System.out.printf("ReCalculating Array for %d millis %n",System.currentTimeMillis()-start_time);
        //flows.PrintArray(arr);

    }
}

package week_1;

public class ChickAndHen {
    static int cock_pride = 5;
    static int hen_pride = 3;
    static float chick_pride = 1/3;

    public static void main(String[] args) {
//        int[] x = setArr();
//        double[] y = new double[100];
//        for (int i=0; i<x.length;i++) {
//            long res = calculate(x[i]);
//            y[i] = res*Math.pow(10,-6);
//        }
//        prt(x);
//        prt(y);
        long calculate = calculate(1000);
        prt(calculate);
    }

    public static int[] setArr() {
        int number = 10000/100;
        int first = 100;
        int[] arr = new int[number];
        for (int i=0; i<number; i++) {
            arr[i] = first;
            first += 100;
        }
        return arr;
    }

    public static long calculate(int sum) {
        int cock_number_top = sum/cock_pride;
        int hen_number_top = sum/ hen_pride;
        long start = System.nanoTime();
        for(int cock_number=0;cock_number<=cock_number_top;cock_number++) {
            for(int hem_number=0;hem_number<=hen_number_top;hem_number++) {
                int chick_number = sum - cock_number - hem_number;
                if(chick_number%3==0 && (cock_number*cock_pride+hem_number* hen_pride +
                chick_number*chick_pride)==100){}
            }
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static void prt(int[] arr) {
        for (int i: arr) {
            System.out.print(i+",");
        }
        System.out.println();
    }

    public static void prt(double[] arr) {
        for (double i: arr) {
            System.out.print(i+",");
        }
        System.out.println();
    }

    public static void prt(double l) {
        System.out.println(l*Math.pow(10,-6) + "ms");
    }
}

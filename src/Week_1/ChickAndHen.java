package Week_1;


public class ChickAndHen {
    static int cock_pride = 5;
    static int hen_pride = 3;
    static float chick_pride = 1/3;

    public static void main(String[] args) {
        int sum = 10000;
        long calculate = calculate(sum);
        prt(calculate);
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
    public static void prt(long l) {
        System.out.println(l* Math.pow(10,-6) + "ms");
    }
}

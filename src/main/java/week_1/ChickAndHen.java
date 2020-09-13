package week_1;

/**
 * 百钱百鸡问题：
 * 公鸡cock  5元一只
 * 母鸡hen   3元一只
 * 小鸡chick 1元3只
 * 今有钱百(100)要买100只鸡
 * 求公鸡母鸡小鸡各几何
 * @author wangwei
 */
public class ChickAndHen {
    //公鸡钱数
    static int cock_pride = 5;
    //母鸡钱数
    static int hen_pride = 3;
    //小鸡单只钱数
    static float chick_pride = 1/3;

    public static void main(String[] args) {
        int[] x = setArr();
        double[] y = new double[100];
        for (int i=0; i<x.length;i++) {
            long res = calculate(x[i]);
            y[i] = res;
        }
        prt(x);
        prt(y);
//        long calculate = calculate(4000);
//        prt(calculate);
    }

    /**
     *生成不同钱数,不同鸡数的数组
     */
    public static int[] setArr() {
        int number = 10000/100;
        int first = 100;
        int[] arr = new int[number];
        for (int i=0; i<number; i++) {
            arr[i] = first;
            first += number;
        }
        return arr;
    }

    /**
     *计算结果
     * 返回算法运行的时间
     * @param sum 钱数鸡数
     * @return 返回时间，单位纳秒(ns)
     */
    public static long calculate(int sum) {
        //最大可能的公鸡数
        int cock_number_top = sum/cock_pride;
        //最大可能的母鸡数
        int hen_number_top = sum/ hen_pride;
        //开始时间
        long start = System.nanoTime();
        //公鸡数从0开始递增
        for(int cock_number=0;cock_number<=cock_number_top;cock_number++) {
            //母鸡数从0开始递增
            for(int hem_number=0;hem_number<=hen_number_top;hem_number++) {
                //小鸡数
                int chick_number = sum - cock_number - hem_number;
                //小鸡数量必须是3的倍数,各种鸡的数量和价格乘积为钱数
                if(chick_number%3==0 && ((cock_number*cock_pride+hem_number* hen_pride +
                chick_number*chick_pride)==sum)){}
            }
        }
        long end = System.nanoTime();
        return end - start;
    }

    /**
     * 打印数组
     * @param arr 需要打印的数组
     */
    public static void prt(int[] arr) {
        for (int i: arr) {
            System.out.print(i+",");
        }
        System.out.println();
    }

    /**
     * 打印数组
     * @param arr 需要打印的数组
     */
    public static void prt(double[] arr) {
        for (double i: arr) {
            System.out.print(i*Math.pow(10,-6)+",");
        }
        System.out.println();
    }

    /**
     * 打印时间
     * @param l 传入需要打印的时间,单位ns(纳秒)
     */
    public static void prt(double l) {
        System.out.println(l*Math.pow(10,-6) + "ms");
    }
}

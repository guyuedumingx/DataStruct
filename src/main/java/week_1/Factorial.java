package week_1;

/**
 * 阶乘的递归算法和非递归算法的时间复杂度比较
 * @author wangwei
 */
public class Factorial {
    public static void main(String[] args) {
        int number = 25;
        Factorial f = new Factorial();

        long factorialTimeStart = System.nanoTime();
        f.factorial(number);
        long factorialTimeEnd = System.nanoTime();
        System.out.println("----Factoral----");
        f.prtTime(factorialTimeEnd-factorialTimeStart);


        f.unfactorial(number);
    }

    /**
     * 递归法
     * @param n 阶乘数
     * @return 算法运行的时间
     */
    public long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }

    /**
     * 非递归法
     * @param n 阶乘数
     */
    public void unfactorial(int n) {
        long sum = 1;
        long start = System.nanoTime();
        for(long i=1; i<=n; i++) {
            sum *= i;
        }
        long end = System.nanoTime();
        System.out.println("----UnFactoral----");
        prtTime(end - start);
    }

    /**
     * 打印时间
     * @param time 传入的时间,单位纳秒ns
     */
    public void prtTime(long time) {
        System.out.println("Spends: " + time*Math.pow(10,-6) + "ms");
    }
}

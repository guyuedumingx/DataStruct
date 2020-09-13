package week_1;

public class Fabonacci {
    public static void main(String[] args) {
        int n = 40;
        Fabonacci fabonacci = new Fabonacci();

        long start1 = System.nanoTime();
        fabonacci.factorial(n);
        long end1 = System.nanoTime();
        prtTime("Factorial",end1-start1);

        long start2 = System.nanoTime();
        fabonacci.unFactorial(n);
        long end2 = System.nanoTime();
        prtTime("UnFactorial",end2-start2);
    }

    public long factorial(int n) {
        if(n == 1)
            return 0;
        else if(n == 2)
            return 1;
        else
            return factorial(n-1) + factorial(n - 2);
    }

    public long unFactorial(int n) {
        long now = 0;
        if (n == 1)
            return 0;
        else if( n == 2)
            return 1;
        else {
            for(long i = 3,p = 1,pp = 0; i<=n; i++) {
                now = p + pp;
                pp = p;
                p = now;
            }
        }
        return now;
    }

    public static void prtTime(String msg,long time) {
        System.out.println("----" + msg + "----");
        System.out.println("Spends: " + time*Math.pow(10,-6) + "ms");
    }

    /**
     * @// TODO: 9/10/20
     * @param n
     * @return
     */
    public long unFactorialBook(int n) {
        int i = 0, j = 1, k = 1;
        while (k <= n) {
            i = i + j;
            j = i + j;
            k = k + 2;
        }
        if(k == n)
            return i;
        else
            return j;
    }
}

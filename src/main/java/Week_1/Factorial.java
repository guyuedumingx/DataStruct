package main.Week_1;

public class Factorial {
    public static void main(String[] args) {
        int number = 25;
        Factorial f = new Factorial();


        long factorialTimeStart = System.nanoTime();
        long res =  f.factorial(number);
        long factorialTimeEnd = System.nanoTime();
        System.out.println("----Factoral----");
        f.prtTime(factorialTimeEnd-factorialTimeStart);


        f.unfactorial(number);
    }

    public long factorial(int n) {
        if (n == 1)
            return 1;
        else
            return n * factorial(n-1);
    }

    public void unfactorial(int n) {
        long sum = 1;
        long start = System.nanoTime();
        for(long i=1; i<=n; i++)
           sum *= i;
        long end = System.nanoTime();
        System.out.println("----UnFactoral----");
        prtTime(end - start);
    }

    public void prtTime(long time) {
        System.out.println("Spends: " + time*Math.pow(10,-6) + "ms");
    }
}

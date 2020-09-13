package week_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) throws FileNotFoundException {

        int[] arr1 = new BubbleSort().getNumbers(10000);
        int[] arr2 = new BubbleSort().getNumbers(10000);
        long time1 = sort(arr1);
        long time2 = quick(arr2);
        System.out.println("-------- Bubble Sort --------");
        prtTime(time1);
        System.out.println("-------- Quick  Sort --------");
        prtTime(time2);
    }

    public static long sort(int[] arr) {
        long start = System.nanoTime();
        for(int i=0; i<=arr.length; i++) {
           for(int n=0; n<arr.length-i-1;n++) {
               if(arr[n] > arr[n+1]) {
                   int temp = arr[n+1];
                   arr[n+1] = arr[n];
                   arr[n] = temp;
               }
           }
       }
        long end = System.nanoTime();
        return end - start;
    }

    public int[] getNumbers(int number) throws FileNotFoundException {
        String path = this.getClass().getClassLoader().getResource("datafile.txt").getPath();

        Scanner in = new Scanner(new File(path));
        String str = in.next();
        String[] split = str.split(",");

        int[] nums = new int[number];
        for(int i=0; i<number;i++) {
            nums[i] = Integer.valueOf(split[i]);
        }
        return nums;
    }

    public static long quick(int[] arr) {
       long start = System.nanoTime();
       Arrays.sort(arr);
       long end = System.nanoTime();
       return end - start;
    }

    public static void prtArr(int[] arr) {
        for (int i: arr) {
            System.out.print(i+"\t");
        }
    }

    public static void prtTime(long time) {
        System.out.println("\nSpends: " + time*Math.pow(10,-6) +"ms");
    }
}

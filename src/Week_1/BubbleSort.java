package Week_1;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,25,14,56,62,45,51};
        int[] arr2 = new int[]{1,3,25,14,56,62,45,51};
        long time1 = sort(arr1);
        long time2 = quick(arr2);
        System.out.println("-------- Bubble Sort --------");
        prtArr(arr1);
        prtTime(time1);
        System.out.println("-------- Quick  Sort --------");
        prtArr(arr2);
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

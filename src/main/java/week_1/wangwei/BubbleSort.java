package week_1.wangwei;

import java.io.FileNotFoundException;
import java.util.Arrays;

import static util.ReadData.*;


/**
 * 该类用于比较冒泡排序和快速排序
 * @author wangwei
 */
public class BubbleSort {
    public static void main(String[] args) throws FileNotFoundException {

        int[] arr1 = getNumbersFromZero(10000);
        int[] arr2 = getNumbersFromZero(10000);
        long time1 = sort(arr1);
        long time2 = quick(arr2);
        System.out.println("-------- Bubble Sort --------");
        prtTime(time1);
        System.out.println("-------- Quick  Sort --------");
        prtTime(time2);
    }

    public static long sort(int[] arr) {
        long start = System.nanoTime();
        for(int i=0; i<=arr.length-1; i++) {
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

    /**
     * 课本模板
     */
    public static long template(int[] arr) {
        long start = System.nanoTime();
        for(int i=1; i<arr.length; i++) {
            for(int n=0; n<arr.length-i; n++) {
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


    /**
     * 调用Arrays中的sort()函数进行快速排序
     * @param arr 需要排序的数组
     * @return 排序所耗时间
     */
    public static long quick(int[] arr) {
       long start = System.nanoTime();
       Arrays.sort(arr);
       long end = System.nanoTime();
       return end - start;
    }

    /**
     * 打印数组
     * @param arr 需要打印的数组
     */
    public static void prtArr(int[] arr) {
        for (int i: arr) {
            System.out.print(i+"\t");
        }
    }

    /**
     * 打印时间
     * 传入的时间单位为ns(纳秒)
     * @param time 传入的时间
     */
    public static void prtTime(long time) {
        System.out.println("Spends: " + time*Math.pow(10,-6) +"ms");
    }
}

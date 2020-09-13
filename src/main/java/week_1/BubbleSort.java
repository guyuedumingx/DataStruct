package week_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


/**
 * 该类用于比较冒泡排序和快速排序
 * @author wangwei
 */
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

    /**
     * 从datafile.txt文件中获取需要排序的数字，datafile.txt文件在resources文件夹下
     * @param number 需要从文件中读取的数字数量
     * @return 返回读取的int[]数组
     * @throws FileNotFoundException 找不到datafile.txt文件
     */
    public int[] getNumbers(int number) throws FileNotFoundException {
        String path = this.getClass().getClassLoader().getResource("datafile.txt").getPath();

        Scanner in = new Scanner(new File(path));
        String str = in.next();
        //把datafile.txt中的数字按，分割成String 数组
        String[] split = str.split(",");

        int[] nums = new int[number];

        //读取前number位数字
        for(int i=0; i<number;i++) {
            nums[i] = Integer.valueOf(split[i]);
        }
        return nums;
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

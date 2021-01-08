package exam.wangwei.review.sort.choose;

import exam.wangwei.review.sort.SortUtil;
import util.ReadData;

/**
 * 直接选择排序
 * Straight Selection Sort
 * 第一趟，从n个记录中找出关键字最小的记录与第1个记录交换
 * 第2趟，从n-1个记录中再选出关键字最小的记录与第二个记录交换
 * .....
 * @author yohoyes
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = ReadData.getNumbersFromZero(100);
        sort(arr);
        SortUtil.prt(arr);
    }

    public static void sort(int[] arr) {

        for(int i=0; i<arr.length; i++) {
            int min = i;
            for(int j=i; j<arr.length; j++) {
               if(arr[min] > arr[j]) {
                   min = j;
               }
            }
            if(min != i) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }
}

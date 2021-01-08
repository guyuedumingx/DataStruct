package exam.wangwei.review.sort.change;

import com.sun.org.apache.xerces.internal.impl.dv.xs.BaseDVFactory;
import exam.wangwei.review.sort.SortUtil;
import util.ReadData;

/**
 * 冒泡排序算法
 * @author yohoyes
 */
public class BubbleSort {

    public static void sort(int[] arr) {
       for (int i=1; i<arr.length; i++) {

          for(int j=0; j<arr.length-i; j++) {
              if(arr[j] > arr[j+1]) {
                  int tmp = arr[j];
                  arr[j] = arr[j+1];
                  arr[j+1] = tmp;
              }
          }
       }
    }

    public static void main(String[] args) {
        int[] arr = ReadData.getNumbersFromZero(100);
        sort(arr);
        SortUtil.prt(arr);
    }
}

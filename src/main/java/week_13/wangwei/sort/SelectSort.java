package week_13.wangwei.sort;

import util.ReadData;
import util.wangwei.MyArray;

/**
 * 选择排序
 * @author yohoyes
 */
public class SelectSort {

    public static void sort(int[] data) {
        for(int i=0; i<data.length; i++) {
            int min = i;
            for(int j=i; j<data.length; j++) {
                if(data[min] > data[j]) {
                    min = j;
                }
            }
            if(min != i) {
                int tmp = data[i];
                data[i] = data[min];
                data[min] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = ReadData.getNumbersFromZero(10);
        MyArray.prt(nums);
        sort(nums);
        MyArray.prt(nums);
    }
}

package week_13.wangwei.sort;

import util.ReadData;
import util.wangwei.MyArray;

/**
 * 插入排序
 * @author yohoyes
 */
public class InsertSort {

    public static void sort(int[] data) {
        for(int i=1; i<data.length; i++) {
            int tmp = data[i];
            int j = i;
            while(j>0 && data[j-1]>tmp) {
                data[j] = data[j-1];
                j--;
            }
            if(i != j) {
                data[j] = tmp;
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

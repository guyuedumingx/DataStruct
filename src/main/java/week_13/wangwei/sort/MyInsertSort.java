package week_13.wangwei.sort;

import util.ReadData;
import util.wangwei.MyArray;

/**
 * 插入排序
 * @author yohoyes
 */
public class MyInsertSort {

    public static void sort(int[] data) {
        for(int i=1; i<data.length; i++) {
            int cur = i;
            for(int j=i-1; j>=0; j--) {
                if(data[j] < data[cur]) {
                    insert(data,cur,j+1);
                    break;
                }else if(j==0 && cur!=0) {
                   insert(data,cur,j);
                }
            }
        }
    }

    private static void insert(int[] data, int i, int index) {
        if(i == index) {
            return;
        }
        int tmp = data[i];
        for(int j=i-1; j>=index; j--) {
            data[j+1] = data[j];
        }
        data[index] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = ReadData.getNumbersFromZero(10);
        MyArray.prt(nums);
        sort(nums);
        MyArray.prt(nums);
    }
}

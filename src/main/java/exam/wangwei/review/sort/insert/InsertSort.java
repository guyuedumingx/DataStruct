package exam.wangwei.review.sort.insert;

import exam.wangwei.review.sort.SortUtil;
import util.ReadData;

/**
 * 插入排序
 * 每次取一位待排序的值
 * 插入到前面已排序的适当位置
 * @author yohoyes
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = ReadData.getNumbersFromZero(100);
        sort(arr);
        SortUtil.prt(arr);
    }

    public static void sort(int[] arr) {
        for(int j=1; j<arr.length; j++) {

            //一次循环，解决一个数
            for(int i=j; i>0; i--) {

                //找到合适的位置
                if(arr[i] < arr[i-1]) {

                    //交换
                    int tmp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

}

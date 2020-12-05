package week_13.wangwei;

import util.ReadData;
import util.wangwei.MyArray;

/**
 * 堆排序
 * @author yohoyes
 */
public class HeapSort {

    static int len = 0;

    public static void sort(int[] data) {
        len = data.length;
        buildMaxHeap(data);
        for(int i=data.length-1; i>1; i--) {
            swap(data,1, i);
            len--;
            heapfiy(data, 1);
        }
    }


    /**
     * 建立大顶堆
     * 根节点在data[1]
     * @param data
     */
    protected static void buildMaxHeap(int[] data) {
        int end = data.length / 2;
        for(int cur=end; cur>0; cur--) {
            heapfiy(data,cur);
        }
    }

    /**
     * 堆调整
     * @param data
     */
    protected static void heapfiy(int[] data,int cur) {
        int left = 2 * cur;
        int right = 2 * cur + 1;
        int max = cur;

        if(left<len && data[left]>data[max]) {
            max = left;
        }

        if(right<len && data[right]>data[max]) {
            max = right;
        }

        if(max != cur) {
            swap(data,max,cur);
            //主要用于下沉
            heapfiy(data,max);
        }
    }

    protected static void swap(int[] data, int max, int cur) {
        int tmp = data[max];
        data[max] = data[cur];
        data[cur] = tmp;
    }

    public static void main(String[] args) {
        int[] data = ReadData.getNumbersFromOne(15);
        MyArray.prt(data);
        sort(data);
        MyArray.prt(data);
    }
}

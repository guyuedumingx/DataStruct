package exam.wangwei.review.sort.change;

/**
 * 快速排序
 * @author yohoyes
 */
public class QuickSort {
    private int[] arr = null;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    /**
     * 一趟快速排序
     * 从表的两端交替地向中间扫描
     */
    public int partition(int i, int j) {
        int pivot = arr[i];

        while (i<j) {
            while (i<j && pivot<arr[j]) {
                j--;
            }
            if(i<j) {
                arr[i] = arr[j];
                i++;
            }
            while (i<j && pivot>arr[i]){
                i++;
            }
            if(i<j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = pivot;
        return i;
    }

    public void sort(int low, int high) {
        if(low < high) {
            int pivot = partition(low, high);
            sort(low, pivot-1);
            sort(pivot+1, high);
        }
    }
}

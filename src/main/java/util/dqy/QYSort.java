package util.dqy;

public class QYSort {

    //------------------------------------非线性时间比较类------------------------------------

    /**
     * 插入排序
     */

    //直接插入排序
    public static void insertSort(int[] arr) {
        int[] orderArr = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            int idx = i;
            while (idx > 0 && arr[i] < arr[idx - 1]) idx--;
            int tmp = arr[i];
            for (int j = i; j > idx; j--) {
                arr[j] = arr[j - 1];
            }
            arr[idx] = tmp;
        }
    }

    //希尔排序


    /**
     * 交换排序
     */
    //冒泡排序
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    arr[j] ^= arr[j - 1];
                    arr[j - 1] ^= arr[j];
                    arr[j] ^= arr[j - 1];
                }
            }
        }
    }

    //快速排序
    private static void qs(int[] arr, int l, int r) {
        if (l >= r) return;
        int x = arr[(l + r) >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (arr[i] < x);
            do j--; while (arr[j] > x);
            if (i < j) {
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
            }
        }
        qs(arr, l, j);
        qs(arr, j + 1, r);
    }

    public static void quickSort(int[] arr) {
        qs(arr, 0, arr.length - 1);
    }

    /**
     * 选择排序
     */

    public static void selectSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int mn = 0x3f3f3f3f, idx = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < mn) {
                    idx = j;
                    mn = arr[j];
                }
            }
            for (int j = idx; j > i; j--) {
                arr[j] = arr[j - 1];
            }
            arr[i] = mn;
        }
    }

    /**
     * 归并排序
     */

    private static void ms(int[] tmp, int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        ms(tmp, arr, l, mid);
        ms(tmp, arr, mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }
        //把剩余的数字放入数组
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= r) tmp[k++] = arr[j++];
        for (int idxI = l, idxJ = 0; idxI <= r; idxI++, idxJ++) arr[idxI] = tmp[idxJ];
    }

    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        ms(tmp, arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp[i];
        }
    }

    //------------------------------------线性时间非比较类------------------------------------
}

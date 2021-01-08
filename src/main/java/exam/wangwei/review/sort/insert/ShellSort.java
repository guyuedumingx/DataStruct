package exam.wangwei.review.sort.insert;

/**
 * 希尔排序
 * 选择一个增量，按照这个增量数组分割带排序数组
 * 将分割的数组进行直接插入排序
 * 逐步缩小增量，重复分割排序步骤
 * 直到增量为1
 * @author yohoyes
 */
public class ShellSort {

    public static void sort(int[] d, int[] arr) {
        int j, temp;

        for (int dk : d) {
            //每次选择一个增量
            for (int i = dk; i < arr.length; i++) {
                temp = arr[i];
                for (j = i - dk; j >= 0 && temp < arr[j]; j -= dk) {
                    arr[j + dk] = arr[j];
                }
                arr[j + dk] = temp;
            }
        }
    }
}

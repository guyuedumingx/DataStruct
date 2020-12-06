package week_13.wangwei;

/**
 * 基数排序
 * @author yohoyes
 */
public class RadixSort {

    public static void sort(int[] data) {
        if(data.length <= 0) {
            return;
        }
    }

    protected static void radixSort(int[] data) {
        int[][] radix = new int[10][data.length];
        int digitLength = getNumberLength(data);
        int times = 1;
        while (times <= digitLength) {
            for(int i=0; i<data.length; i++) {
                int num = getNumberFromTimes(data[i], times);

            }
            times++;
        }
    }

    protected static int getNumberFromTimes(int number, int times) {
        int res = 0;
        for(int i=0; i<times; i++) {
            res = number % 10;
            number /= 10;
            if(number < 1) {
                return 0;
            }
        }
        return res;
    }

    protected static int getNumberLength(int[] data) {
        int i = 0;
        int maxValue = getMaxValue(data);

        while (maxValue > 0) {
            maxValue /= 10;
            i++;
        }
        return i;
    }

    protected static int getMaxValue(int[] data) {
        int max = data[0];
        for(int i=1; i < data.length; i++) {
            if(data[i] >= max) {
                max = data[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {

    }
}

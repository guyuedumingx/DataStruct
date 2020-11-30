package week_12.wangwei;

import util.ReadData;

/**
 * 希尔排序
 * @author yohoyes
 */
public class ShellSort {

    public static void main(String[] args) {
        int number = 100;
        int[] numbers = ReadData.getNumbers(number);
        prt(numbers);
        int[] sort = sort(numbers);
        prt(sort);
    }

    private static int[] sort(int[] data){
        int[] sortArrays = getFabonacciArrays(data.length);
        for(int n = sortArrays.length-1; n>0; n--) {
            int gap = sortArrays[n];
            insertSort(data, gap);
        }
        return data;
    }

    private static void insertSort(int[] data, int gap) {
        int tmp,j;
        for(int i = gap; i < data.length; i++){
            tmp = data[i];
            for(j = i-gap; j >= 0; j = j-gap){
                if(data[j] > tmp){
                    data[j+gap] = data[j];
                }else{
                    break;
                }
            }
            data[j+gap] = tmp;
        }
    }

    /**
     * 获取直到大于N的斐波那契数列
     */
    private static int[] getFabonacciArrays(int n){
        int[] res = new int[getLength(n)];
        res[0] = 1;
        res[1] = 1;
        for(int i=2; res[i-1]< n/2; i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res;
    }

    private static int getLength(int n){
        int pre = 1;
        int cur = 1;
        int i = 2;
        while (cur < n/2) {
            cur = cur + pre;
            pre = cur - pre;
            i++;
        }
        return i;
    }

    private static void prt(int[] data) {
        for(int i : data) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

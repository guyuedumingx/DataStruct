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
        int[] fabonacciArrays = getFabonacciArrays(data.length);
        for(int n=fabonacciArrays.length-1; n>=0; n--) {
            int distant=fabonacciArrays[n];
            System.out.println(distant);
            for(int i=0;i+distant<data.length; i++) {
                if(data[i]>data[i+distant]) {
                    int temp = data[i+distant];
                    data[i+distant] = data[i];
                    data[i] = temp;
                }
            }
            prt(data);
        }
        return data;
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

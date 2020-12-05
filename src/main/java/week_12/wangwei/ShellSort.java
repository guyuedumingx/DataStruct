package week_12.wangwei;

import util.ReadData;
import util.wangwei.MyArray;

/**
 * 希尔排序
 * @author yohoyes
 */
public class ShellSort {

    public static void main(String[] args) {
        int number = 10;
        int[] numbers = ReadData.getNumbersFromZero(number);
        MyArray.prt(numbers);
        int[] sort = sort(numbers);
        MyArray.prt(sort);
    }

    private static int[] sort(int[] data){
        int[] sortArrays = getFabonacciArrays(data.length);
        for(int n = sortArrays.length-1; n>0; n--) {
            int gap = sortArrays[n];
            insertSort(data, gap);
        }
        return data;
    }

    /**
     * 单次排序
     */
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
     * 这个函数根据传入的n判断应该返回的斐波那契数组应该是多长，怎样的
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

    /**
     * 这个只是用来获取数组应该开多大的
     * 有没有无所谓的，你只要把数组开的足够大就行
     * 不过这里我也跑了一遍状态压缩版的动态规划
     * 您可以康康
     */
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

}

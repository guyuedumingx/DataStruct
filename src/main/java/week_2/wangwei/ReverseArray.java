package week_2.wangwei;

import week_2.wangwei.marquee.TwoDimensional;

public class ReverseArray {

    public static void main(String[] args) {
        int[] array = createArray(10);
        for(int i=array.length-1; i>array.length/2; i--) {
            int j = array.length-1 - i;
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
    }

    public static int[] createArray(int x) {
        int[] arr = new int[x];
        for(int i=0; i<x; i++) {
            arr[i] = i+1;
        }
        return arr;
    }

    public static void prt(int[] arr) {
        for(int i : arr) {
            System.out.print(i+"\t");
        }
    }
}

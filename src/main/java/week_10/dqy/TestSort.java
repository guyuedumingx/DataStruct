package week_10.dqy;

import util.dqy.QYSort;

public class TestSort {
    public static void main(String[] args) {
        int[] arr = {52, 39, 67, 95, 70, 8, 25, 52};
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
        QYSort.selectSort(arr);
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}

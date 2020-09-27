//一维跑马灯
package week_2.dqy.w5;

import java.util.Scanner;

public class Main {

    public static void move(int step, int[] arr) {
        int[] temp = new int[500];
        for (int j = 0, i = 100 - step; i < 100; j++, i++) {
            temp[j] = arr[i];
        }
        for (int i = 100 - step; i >= 0; i--) {
            arr[i + step] = arr[i];
        }
        for (int i = 0; i < step; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int[] arr = new int[500], op = {2, 3, 5, 8, 13};
        int index = 0, flag = 0, step, len = 0;
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        while (index != 0 || flag == 0) {
            flag = 1;
            len = len > 5 ? 0 : len;
            step = op[len];
            index = (index + step) % 100;
            move(step,arr);
            for (int i = 0; i < 100; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

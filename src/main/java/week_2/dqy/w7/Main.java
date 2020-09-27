//三维跑马灯
package week_2.dqy.w7;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void turnX(int arr[][][], int axis) {
        int tmp;
        tmp = arr[0][0][axis];
        arr[0][0][axis] = arr[0][2][axis];
        arr[0][2][axis] = arr[2][2][axis];
        arr[2][2][axis] = arr[2][0][axis];
        arr[2][0][axis] = tmp;
        tmp = arr[1][0][axis];
        arr[1][0][axis] = arr[0][1][axis];
        arr[0][1][axis] = arr[1][2][axis];
        arr[1][2][axis] = arr[2][1][axis];
        arr[2][1][axis] = tmp;
    }

    public static void turnY(int arr[][][], int axis) {
        int tmp;
        tmp = arr[0][axis][0];
        arr[0][axis][0] = arr[0][axis][2];
        arr[0][axis][2] = arr[2][axis][2];
        arr[2][axis][2] = arr[2][axis][0];
        arr[2][axis][0] = tmp;
        tmp = arr[1][axis][0];
        arr[1][axis][0] = arr[0][axis][1];
        arr[0][axis][1] = arr[1][axis][2];
        arr[1][axis][2] = arr[2][axis][1];
        arr[2][axis][1] = tmp;
    }

    public static void turnZ(int arr[][][], int axis) {
        int tmp;
        tmp = arr[axis][0][0];
        arr[axis][0][0] = arr[axis][0][2];
        arr[axis][0][2] = arr[axis][2][2];
        arr[axis][2][2] = arr[axis][2][0];
        arr[axis][2][0] = tmp;
        tmp = arr[axis][1][0];
        arr[axis][1][0] = arr[axis][0][1];
        arr[axis][0][1] = arr[axis][1][2];
        arr[axis][1][2] = arr[axis][2][1];
        arr[axis][2][1] = tmp;
    }

    public static void printPic(int arr[][][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(arr[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner src = new Scanner(System.in);
        int x = 0, y = 0, z = 0, num = 10;
        int[][][] arr = new int[3][3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    arr[i][j][k] = num++;
                }
            }
        }
        printPic(arr);
        x = src.nextInt();
        y = src.nextInt();
        z = src.nextInt();
        turnX(arr, x);
        turnY(arr, y);
        turnZ(arr, z);
        printPic(arr);
    }
}
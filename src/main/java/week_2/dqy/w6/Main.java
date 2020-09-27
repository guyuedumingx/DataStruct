package week_2.dqy.w6;

import java.util.Scanner;

public class Main {

    public static void turn(int[][] arr, int[][] mir, int len) {
        int sx = 0, sy = 0, lawyer = len / 2;
        for (int i = 0; i < lawyer; i++) {
            for (int j = 0; j < len - 1; j++) {
                mir[i][j] = arr[sy][sx + j];
                mir[i][j + len - 1] = arr[sy + j][sx + len - 1];
                mir[i][j + (len - 1) * 2] = arr[sy + len - 1][sx + len - 1 - j];
                mir[i][j + (len - 1) * 3] = arr[sx + len - 1 - j][sx];
            }
            sx++;
            sy++;
            len -= 2;
        }
    }

    public static void turnBack(int[][] arr, int[][] mir, int len) {
        int sx = 0, sy = 0, lawyer = len / 2;
        for (int i = 0; i < lawyer; i++) {
            for (int j = 0; j < len - 1; j++) {
                arr[sy][sx + j] = mir[i][j];
                arr[sy + j][sx + len - 1] = mir[i][j + len - 1];
                arr[sy + len - 1][sx + len - 1 - j] = mir[i][j + (len - 1) * 2];
                arr[sx + len - 1 - j][sx] = mir[i][j + (len - 1) * 3];
            }
            sx++;
            sy++;
            len -= 2;
        }
    }

    public static void moveForward(int step, int[] arr, int lenArr) {
        int[] temp = new int[500];
        for (int j = 0, i = lenArr - step; i < lenArr; j++, i++) {
            temp[j] = arr[i];
        }
        for (int i = lenArr - step - 1; i >= 0; i--) {
            arr[i + step] = arr[i];
        }
        for (int i = 0; i < step; i++) {
            arr[i] = temp[i];
        }
    }

    public static void moveBack(int step, int[] arr, int lenArr) {
        int[] temp = new int[500];
        for (int j = 0, i = 0; i < step; j++, i++) {
            temp[j] = arr[i];
        }
        for (int i = step; i < lenArr; i++) {
            arr[i - step] = arr[i];
        }
        for (int i = lenArr - step, j = 0; i < lenArr; i++, j++) {
            arr[i] = temp[j];
        }
    }

    public static void moveCycle(int step, int[][] mir, int lenArr) {
        int len = lenArr / 2;
        int flag = 1;
        for (int j = 0; j < len; j++) {
            if (flag == 1) {
                moveForward(step, mir[j], (lenArr - 1 - j * 2) * 4);
                flag = 0;
            } else {
                moveBack(step, mir[j], (lenArr - 1 - j * 2) * 4);
                flag = 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int[][] arr = new int[500][500], mir = new int[500][500];
        int startNode = 0, flag = 0, step, len = 0, x = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = ++x;
            }
        }
        step = src.nextInt();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
         do{
            startNode=(startNode+step)%20;
            turn(arr, mir, 6);
            System.out.println();
            moveCycle(3, mir, 6);
            turnBack(arr, mir, 6);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }while (startNode!=0);
    }
}


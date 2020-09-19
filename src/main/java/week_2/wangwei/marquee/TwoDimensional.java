package week_2.wangwei.marquee;

import java.io.IOException;

/**
 * 二维数组跑马灯
 * @author wangwei
 */
public class TwoDimensional {
    private static int step = 2;
    private static int origin_length = 6;
    private static int length = origin_length;
    private static int[][] arr = createArray(origin_length);
    private static int[][] res = new int[origin_length][origin_length];
    private static int[] diagonalNumbers = new int[origin_length/2];

    public static void main(String[] args) throws IOException {
        saveDiagonalsNumbers();
        do {
            prt(arr);
            for(int i=0; i<origin_length/2; i++) {
                goRight(i, i);
                goDown(i, length - 1);
                goLeft(length - 1, length - 1);
                goUp(length - 1, i);
                length -= 1;
            }
            length = origin_length;
            arr = res;
            res = new int[origin_length][origin_length];
        }while (!isEquals(arr));
        prt(arr);
    }

    private static void saveDiagonalsNumbers() {
       for(int i=0; i<origin_length/2; i++) {
           diagonalNumbers[i] = arr[i][i];
       }
    }

    private static boolean isEquals(int[][] arr) {
        boolean flag = true;
        for(int i=0; i<origin_length/2 && flag; i++) {
            flag = (diagonalNumbers[i]==arr[i][i]);
        }
        return flag;
    }

    private static void goRight(int i, int j) {
        while (j+step<length) {
            res[i][j+step] = arr[i][j++];
        }
        while (j<length-1) {
            int k = (j+step)%(length-1);
            res[i+k][length-1] = arr[i][j++];
        }
    }
    private static void goDown(int i, int j) {
        while (i+step<length) {
            res[i+step][j] = arr[i++][j];
        }
        while (i<length-1) {
            int k = (i+step)%(length-1);
            res[length-1][length-k-1] = arr[i++][j];
        }
    }
    private static void goLeft(int i, int j) {
        //最小脚标
        int min = origin_length - length;
        while (j-step>=min) {
            res[i][j-step] = arr[i][j--];
        }
        while (j>min) {
            int k = (origin_length-1-j+step)%(length-1);
            res[length-k-1][min] = arr[i][j--];
        }
    }

    private static void goUp(int i, int j) {
        int min = origin_length - length;
        while (i-step>=min) {
            res[i-step][j] = arr[i--][j];
        }
        while (i>min) {
            int k = (origin_length-i+step)%(length);
            res[min][k+j] = arr[i--][j];
        }
    }

    public static int[][] createArray(int length) {
        int[][] arr =  new int[length][length];
        int n = 1;
        for(int i=0;i<length;i++) {
            for(int j=0; j<length; j++) {
                arr[i][j] = n++;
            }
        }
        return arr;
    }

    public static void prt(int[][] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print("[");
           for (int j=0; j<arr[i].length; j++) {
               System.out.print(arr[i][j]+"\t");
           }
            System.out.println("]");
        }
        System.out.println();
    }
}

package week_2.wangwei.marquee;

import java.io.IOException;

public class ThreeDimensional {
    static int length = 3;
    static int[][][] arr = createArray(length);
    static int[][][] res = new int[length][length][length];
    static int step = 2;
    static int x = 0;
    static int y = 0;
    static int z = 0;
    static char c = 'y';

    public static void main(String[] args) throws IOException {
        int[][] twoDimensionalArray = getTwoDimensionalArray();
        int[][] run = TwoDimensional.run(twoDimensionalArray);
        saveValue(run);
    }



    public static int[][] getTwoDimensionalArray() {
        int[][] temp = new int[length][length];
        int l,m,n;
        l = m = n = 0;
        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                switch (c) {
                    case 'x':
                        l = x;
                        m = i;
                        n = j;
                        break;
                    case 'y':
                        l = i;
                        m = y;
                        n = j;
                        break;
                    case 'z':
                        l = i;
                        m = j;
                        n = z;
                        break;
                }
                temp[i][j] = arr[l][m][n];
            }
        }
        return temp;
    }

    public static void saveValue(int[][] temp) {
        int l,m,n;
        l = m = n = 0;
        for(int i=0; i<length; i++) {
            for (int j = 0; j < length; j++) {
                switch (c) {
                    case 'x':
                        l = x;
                        m = i;
                        n = j;
                        break;
                    case 'y':
                        l = i;
                        m = y;
                        n = j;
                        break;
                    case 'z':
                        l = i;
                        m = j;
                        n = z;
                        break;
                }
                arr[l][m][n] = temp[i][j];
            }
        }
    }

    public static int[][][] createArray(int x) {
        int[][][] arr = new int[x][x][x];
        int z = 0;
        for(int i=0; i<x; i++) {
            for(int j=0; j<x; j++) {
                for(int k=0; k<x; k++) {
                   arr[i][j][k] = ++z;
                }
            }
        }
        return arr;
    }
}

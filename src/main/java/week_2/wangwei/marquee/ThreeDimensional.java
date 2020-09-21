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
    static char c = 'x';

    public static void main(String[] args) throws IOException {
        int[][] twoDimensionalArray = getTwoDimensionalArray();
        int[][] run = TwoDimensional.run(twoDimensionalArray);
        saveValue(run);
        System.out.println("length");
    }



    public static int[][] getTwoDimensionalArray() {
        int[][] temp = new int[length][length];
        switch (c) {
            case 'x':
                for(int i=0; i<length; i++) {
                    for(int j=0; j<length; j++) {
                        temp[i][j] = arr[x][i][j];
                    }
                }
                break;
            case 'y':
                for(int i=0; i<length; i++){
                    for(int j=0; j<length; j++) {
                        temp[i][j] = arr[i][y][j];
                    }
                }
                break;
            case 'z':
                for(int i=0; i<length; i++) {
                    for(int j=0; j<length; j++) {
                        temp[i][j] = arr[i][j][z];
                    }
                }
                break;
        }
        return temp;
    }

    public static void saveValue(int[][] temp) {
        switch (c) {
            case 'x':
                for(int i=0; i<length; i++) {
                    for(int j=0; j<length; j++) {
                        arr[x][i][j] = temp[i][j];
                    }
                }
                break;
            case 'y':
                for(int i=0; i<length; i++){
                    for(int j=0; j<length; j++) {
                        arr[i][y][j] = temp[i][j];
                    }
                }
                break;
            case 'z':
                for(int i=0; i<length; i++) {
                    for(int j=0; j<length; j++) {
                        arr[i][j][z] = temp[i][j];
                    }
                }
                break;
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

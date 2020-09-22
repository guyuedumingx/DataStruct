package week_2.wangwei.marquee;

import java.io.IOException;

/**
 * 三维数组跑马灯
 * 因为三维数组中的旋转必定有一个轴不变，即
 * 实际的单次旋转都是一个二维数组，我们只需要将旋转时
 * 需要变的数组抽取成一个二维数组，再使用二维数组的走马灯旋转
 * 最后把旋转后的二维数组重新赋值給三维数组就可以解决
 */
public class ThreeDimensional {
    static int length = 3;
    static int[][][] arr = createArray(length);
    static int step = 2;
    //哪个轴的哪一层不变
    static int x = 0;
    static int y = 0;
    static int z = 0;
    //哪个轴不变
    static char c = 'z';

    public static void main(String[] args) throws IOException {
        int[][] twoDimensionalArray = getTwoDimensionalArray();
        //使用二维跑马灯旋转数组
        int[][] run = TwoDimensional.run(twoDimensionalArray);
        saveValue(run);
        prt();
    }

    /**
     * 抽取三维数组的子二维数组
     * 即: 若x轴不变,则y,z的变化形成一个二维数组 同理
     * @return
     */
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

    /**
     * 将转过后的二维数组重新赋值到三维数组中
     * @param temp
     */
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

    /**
     * 生成一个三维数组
     * @param x
     * @return
     */
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

    /**
     * 打印三维数组的一个面
     * 即c为轴不变的那个面
     */
    public static void prt() {
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
                System.out.print(arr[l][m][n]+"\t");
            }
            System.out.println();
        }

    }
}

package week_2.wangwei.marquee;

import java.io.IOException;

/**
 * 二维数组跑马灯
 * step支持1-2
 * 只支持顺序
 * @author wangwei
 */
public class TwoDimensional {
    //每次走的步长
    private static int step = 2;
    //初始化的时候的
    private static int origin_length = 3;
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

    /**
     * 保存对角线的数值a[0][0] a[1][1] a[2][2]同一维的first一样负责
     * 查看跑马灯是否跑完
     */
    private static void saveDiagonalsNumbers() {
       for(int i=0; i<origin_length/2; i++) {
           diagonalNumbers[i] = arr[i][i];
       }
    }

    /**
     *验证跑马灯跑回原位
     * @param arr
     * @return
     */
    private static boolean isEquals(int[][] arr) {
        boolean flag = true;
        for(int i=0; i<origin_length/2 && flag; i++) {
            flag = (diagonalNumbers[i]==arr[i][i]);
        }
        return flag;
    }

    /**
     * 跑么灯顶行右走
     * @param i
     * @param j
     */
    public static void goRight(int i, int j) {
        while (j+step<length) {
            res[i][j+step] = arr[i][j++];
        }
        while (j<length-1) {
            int k = (j+step)%(length-1);
            res[i+k][length-1] = arr[i][j++];
        }
    }

    /**
     * 跑马灯右行下走
     * @param i
     * @param j
     */
    public static void goDown(int i, int j) {
        while (i+step<length) {
            res[i+step][j] = arr[i++][j];
        }
        while (i<length-1) {
            int k = (i+step)%(length-1);
            res[length-1][length-k-1] = arr[i++][j];
        }
    }

    /**
     * 跑马灯底行左走
     * @param i
     * @param j
     */
    public static void goLeft(int i, int j) {
        //走到的最小左脚标
        int min = origin_length - length;
        while (j-step>=min) {
            res[i][j-step] = arr[i][j--];
        }
        while (j>min) {
            int k = (origin_length-1-j+step)%(length-1);
            res[length-k-1][min] = arr[i][j--];
        }
    }

    /**
     * 跑马灯左行上走
     * @param i
     * @param j
     */
    public static void goUp(int i, int j) {
        //走到的最小左脚标
        int min = origin_length - length;
        while (i-step>=min) {
            res[i-step][j] = arr[i--][j];
        }
        while (i>min) {
            int k = (origin_length-i+step)%(length);
            res[min][k+j] = arr[i--][j];
        }
    }

    /**
     * 创建一个长度为length的数组
     * @param length
     * @return
     */
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

    /**
     * 打印数组
     * @param arr
     */
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

    public static int[][] run(int[][] in) {
        res = new int[length][length];
        int length = 3;
        arr = in;
        for(int i=0; i<1; i++) {
            goRight(i, i);
            goDown(i, length - 1);
            goLeft(length - 1, length - 1);
            goUp(length - 1, i);
            length -= 1;
        }
        res[length/2][length/2] = arr[length/2][length/2];
        return res;
    }
}

package week_2.wangwei.marquee;

/**
 * 一维数组跑马灯
 * @author wangwei
 */
public class OneDimensional {
    public static void main(String[] args) {
        int[] arr = createArray(200);
        int[] run = run(arr, 3);
        prt(run);
    }

    /**
     * 创建出一个顺序数组，第一位为1
     * @param length 数组长度
     * @return 返回创建的数组
     */
    public static int[] createArray(int length) {
        int[] arr = new int[length];
        for(int i=0; i<length; i++) {
            arr[i] = i+1;
        }
        return arr;
    }

    /**
     * 跑马灯的核心方法
     * @param arr 传入数组
     * @param step 每步移动的步长
     * @return 返回的数组，用于验证
     */
    private static int[] run(int[] arr, int step) {
        int[] res = new int[arr.length];
        int i = 0;
        int j = 0;
        int first = arr[0];
        while (!(res[0]==first && i==arr.length)) {
            if(i==arr.length) {
                prt(res);
                arr = res;
                res = new int[arr.length];
                i = 0;
                j = 0;
            }

            j = (i+step)%arr.length;
            res[j] = arr[i++];
        }
        return res;
    }

    /**
     * 打印数组
     * @param arr 需要打印的数组
     */
    private static void prt(int[] arr) {
        System.out.print("[");
        for(int u: arr) {
            System.out.print(u+"\t");
        }
        System.out.println("]");
    }
}

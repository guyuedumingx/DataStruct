package week_2.wangwei.marquee;

/**
 * 一维数组跑马灯
 * 步长为2时:
 * [1,2,3,4,5,6,7,8,9] -> [8,9,1,2,3,4,5,6,]
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
        //创建一个数组用于保存跑完一次的数据
        int[] res = new int[arr.length];
        //原数组下标指针
        int i = 0;
        //res数组下标指针
        int j = 0;
        //保存原数组的第一位数值，因为该数组的所有值都不相同，所以当res[0]==first的时候
        //跑马灯就跑完了
        int first = arr[0];
        //i==arr.length表示arr完整的遍历了一次,防止出现[1,0,0,0,5,6,7,8,9]这种情况
        while (!(res[0]==first && i==arr.length)) {
            //跑完一次后把res数组给arr，再新建一个res对象进行新一轮的遍历
            if(i==arr.length) {
                prt(res);
                arr = res;
                res = new int[arr.length];
                i = 0;
                j = 0;
            }

            //这个表达式要是看不懂就单步调试来看
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

package week_2.wangwei.PlayingCard;

/**
 * 赌神模式
 * @author wangwei
 */
public class Gambler {
    public static void main(String[] args) {
       int[] arr = createArray(52);
       int[] res = shuffle(arr);
    }

    /**
     * 创建一个数组
     * [0,1,2,3,...51]
     * @param x 数组大小
     * @return 返回生成的数组
     */
    public static int[] createArray(int x) {
        int[] arr = new int[x];
        for(int i=0; i<x; i++) {
           arr[i] = i;
        }
        return arr;
    }

    /**
     * 洗牌方法
     * @param arr1 需要洗牌的数组
     * @return
     */
    public static int[] shuffle(int[] arr1) {
       int[] arr2 = new int[arr1.length];
       //单指针
       int point = arr1.length / 2;
       //间隔
       int len = arr1.length / 2;
       int arr2Point = 0;
       for (int i=0; i<len; i++) {
          arr2[arr2Point++] = arr1[point-len];
          arr2[arr2Point++] = arr1[point++];
       }
       return arr2;
    }
}

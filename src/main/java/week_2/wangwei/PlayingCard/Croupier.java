package week_2.wangwei.PlayingCard;

import java.util.Random;

/**
 * 荷官模式
 * @author wangwei
 */
public class Croupier {
    public static void main(String[] args) {
        int[] arr = Gambler.createArray(52);
        int[] shuffle = shuffle(arr);
    }

    private static int[] shuffle(int[] arr1) {
        int[] arr2 = new int[arr1.length];
        //单指针
        int point = arr1.length / 2 + getRandom(3);
        //间隔
        int len = point;
        //循环次数
        int times = point > (arr1.length/2) ? arr1.length-point : point;
        int arr2Point = 0;
        for (int i=0; i<times; i++) {
            arr2[arr2Point++] = arr1[point - len];
            arr2[arr2Point++] = arr1[point++];
        }
        //偏移部分复制
        if(point!=arr1.length) {
            for(int i=point; i<arr1.length; i++) {
                arr2[arr2Point++] = arr1[i];
            }
        } else {
            for(int i=times; i<point-times; i++) {
                arr2[arr2Point++] = arr1[i];
            }
        }
        return arr2;
    }

    /**
     * 获取一个seed范围内的整数,不包含seed
     *(-seed, seed)
     * @param seed 范围
     * @return 随机数
     */
    private static int getRandom(int seed) {
       return new Random().nextInt(seed*2+1) - seed;
    }
}

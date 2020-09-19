package week_2.wangwei.PlayingCard;

import java.util.Random;

/**
 * 凡人模式
 * 洗牌不平均
 * 单次分牌数不确定
 * @author wangwei
 */
public class Ordinary {
    public static void main(String[] args) {
        //初始化arr数组成[1,2,3,...]
        int[] arr = Gambler.createArray(52);
        //洗牌
        int[] shuffle = shuffle(arr);
        //打印洗牌之后的数组
        for (int i: shuffle) {
            System.out.println(i);
        }
        //打印数组长度
        System.out.println("length:" + shuffle.length);
    }

    /**
     * 洗牌函数
     * @param arr1 需要洗牌的数组
     * @return 洗牌完的数组
     */
    private static int[] shuffle(int[] arr1) {
        //新建一个数组用于存放洗完的牌
        int[] arr2 = new int[arr1.length];
        //原数组的左指针
        int point1 = 0;
        //原数组的右指针
        //随机确定位置,误差在[-9,9]之间
        int point2 = arr1.length/2 + Croupier.getRandom(20);
        //新数组的位置指针
        int point3 = 0;
        //左手牌的边界
        int flag = point2;
        //每次洗牌数
        int pages = 0;


        //如果左指针到达flag处或右指针到达数组长度，则说明有一边手洗完牌了
        while ((point1<flag) && (point2<arr1.length)) {
            //随机确定左手洗的牌数
            pages = new Random().nextInt(6);
            //左手洗牌
            for (int i = 0; (i<pages)&&(point1<flag); i++) {
                arr2[point3++] = arr1[point1++];
            }
            //随机确定右手洗的牌数
            pages = new Random().nextInt(6);
            for (int i = 0; (i<pages)&&(point2<arr1.length); i++) {
                arr2[point3++] = arr1[point2++];
            }
        }
        //一边手洗完牌之后，如果不是两边指针同时到达各自边界，则必有一边手上还有牌,把这些牌复制下来
        //偏移部分复制
        if(point2==arr1.length) {
            for(int i=point1; i<flag; i++) {
                arr2[point3++] = arr1[i];
            }
        } else {
            for(int i=point2; i<arr1.length; i++) {
                arr2[point3++] = arr1[i];
            }
        }
        return arr2;
    }

}

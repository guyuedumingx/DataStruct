package week_2.wangwei.PlayingCard;

import java.util.Random;

/**
 * 凡人模式
 * @author wangwei
 */
public class Ordinary {
    public static void main(String[] args) {
        int[] arr = Gambler.createArray(52);
        int[] shuffle = shuffle(arr);
        for (int i: shuffle) {
            System.out.println(i);
        }
        System.out.println("length:" + shuffle.length);
    }

    private static int[] shuffle(int[] arr1) {
        int[] arr2 = new int[arr1.length];
        int point1 = 0;
        int point2 = arr1.length/2 + Croupier.getRandom(20);
        int point3 = 0;
        int flag = point2;
        int pages = 0;


        while ((point1<flag) && (point2<arr1.length)) {
            pages = new Random().nextInt(6);
            for (int i = 0; (i<pages)&&(point1<flag); i++) {
                arr2[point3++] = arr1[point1++];
            }
            pages = new Random().nextInt(6);
            for (int i = 0; (i<pages)&&(point2<arr1.length); i++) {
                arr2[point3++] = arr1[point2++];
            }
        }
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

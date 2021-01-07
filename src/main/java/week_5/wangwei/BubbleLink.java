package week_5.wangwei;

import util.ReadData;
import util.wangwei.MyLink;
import util.wangwei.Node;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 用链表实现冒泡排序
 * @author yohoyes
 */
public class BubbleLink {

    /**
     * @param number 需要从文件中读取的数字数量
     * @return 返回读取的MyLink数组
     */
    public MyLink<Integer> getNumbers(int number) {
        int[] numbersFromZero = ReadData.getNumbersFromZero(number);
        MyLink<Integer> link = new MyLink<Integer>();

        //读取前number位数字
        for(int i=0; i<number;i++) {
            int integer = numbersFromZero[i];
            link.add(integer);
        }
        return link;
    }

    public static void main(String[] args) throws IOException {
        MyLink<Integer> link = new BubbleLink().getNumbers(10000);
        long sort = sort(link);
        System.out.println(sort*Math.pow(10,-6)+"s");
    }

    public static int getLength(MyLink<Integer> link){
        int i=0;
        Node<Integer> cur = link.head.next;
        while (cur!=null){
            i++;
            cur = cur.next;
        }
        return i;
    }

    public static long sort(MyLink<Integer> link){
        int length = getLength(link);
        long start = System.nanoTime();
        for(int i=1; i<length; i++){
            Node<Integer> cur = link.head;
            for(int j=0; j<length-i;j++){
                if(cur.next.data>cur.next.next.data){
                    Node<Integer> a = cur.next;
                    Node<Integer> b = cur.next.next;
                    a.next = b.next;
                    b.next = a;
                    cur.next = b;
                }
                cur = cur.next;
            }
        }
        long end = System.nanoTime();
        return end-start;
    }
}

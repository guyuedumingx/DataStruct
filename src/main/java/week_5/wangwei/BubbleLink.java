package week_5.wangwei;

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
     * 从datafile.txt文件中获取需要排序的数字，datafile.txt文件在resources文件夹下
     * @param number 需要从文件中读取的数字数量
     * @return 返回读取的MyLink数组
     * @throws FileNotFoundException 找不到datafile.txt文件
     */
    public MyLink<Integer> getNumbers(int number) throws FileNotFoundException {
        String path = this.getClass().getClassLoader().getResource("datafile.txt").getPath();

        Scanner in = new Scanner(new File(path));
        String str = in.next();
        //把datafile.txt中的数字按，分割成String 数组
        String[] split = str.split(",");

        MyLink<Integer> link = new MyLink<Integer>();

        //读取前number位数字
        for(int i=0; i<number;i++) {
            Integer integer = Integer.valueOf(split[i]);
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
        for(int i=0; i<length; i++){
            Node<Integer> cur = link.head;
            for(int j=0; j<length-i-1;j++){
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

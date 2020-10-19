package week_5.wangwei;

import util.wangwei.CircularLink;
import util.wangwei.Node;

/**
 * 约瑟夫问题
 * n 个人围成一圈，从第一个人开始报数,
 * 数到 m 的人出列，再由下一个人重新从 11 开始报数，
 * 数到 m 的人再出圈，依次类推，直到所有的人都出圈，
 * 请输出依次出圈人的编号。
 * @author hoyoyes
 */
public class Joseph {
    static CircularLink<Integer> link = new CircularLink<Integer>();
    static int number = 10;
    static int distant = 3;

    public static void main(String[] args) {
        link.init(createArray(number));
        normal();
    }

    public static Integer[] createArray(int n){
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++){
            arr[i] = number-i;
        }
        return arr;
    }

    /**
     * 普通情况
     * 退出的人不再参与
     * 无概率问题
     */
    public static void normal(){
        int preTag = distant;
        while(link.head.next!=null){
            Node<Integer> curNode = link.head;
            int i = 0;
            for(;curNode!=null&&curNode.next!=null; i++,curNode=curNode.next){
                if(i==preTag){
                    curNode.data = curNode.next.data;
                    curNode.next = curNode.next.next;
                    preTag += distant;
                }
            }
            link.prt();
            preTag = preTag % i;
        }
        link.prt();
    }
}

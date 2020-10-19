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
        Node<Integer> cur = link.head;
        while(link.head.next!=link.head){
            for (int i=1; i < distant; i++){
                if(cur.next==link.head){
                    cur = cur.next.next;
                }else {
                    cur = cur.next;
                }
            }
            if(cur.next==link.head){
                cur = cur.next;
                cur.next = cur.next.next;
            }else {
                cur.next = cur.next.next;
            }
            cur = cur.next;
            link.prt();
        }
    }


}

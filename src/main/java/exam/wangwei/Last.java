package exam.wangwei;


import util.wangwei.MyLink;
import util.wangwei.Node;

/**
 * 2016-2017
 * 第二学期寒冬试题最后一题解法
 * @author yohoyes
 */
public class Last {
    public static void main(String[] args) {
        MyLink<Integer> link = new MyLink<>();
        link.init(buildInitArray(20, 1, 1));
        chOrder(link);

        MyLink<Integer> link1 = new MyLink<>();
        link1.init(buildInitArray(10,1,2));

        MyLink<Integer> link2 = new MyLink<>();
        link2.init(buildInitArray(10,2,2));

        link1.reverse();
        link2.reverse();
        link1.prt();
        link2.prt();

        MyLink<Integer> merge = merge(link1, link2);
        merge.prt();
    }

    private static Integer[] buildInitArray(int len, int first,int step) {
       Integer[] init = new Integer[len];

       for(int i=0; i<len; i++) {
           init[i] = first;
           first += step;
       }
       return init;
    }

    /**
     * 将链表中奇数位置的结点与偶数位置的结点交换
     * 原理是直接看后面两个节点，如果有null，就放回，否则，交换后面的两个节点
     */
    private static void chOrder(MyLink link) {
        Node cur = link.head;

        while (cur.next!=null && cur.next.next!=null) {
            Node next1 = cur.next;
            Node next2 = next1.next;

            cur.next = next2;
            next1.next = next2.next;
            next2.next = next1;

            cur = next1;
        }
    }

    /**
     * 合并两个链表
     */
    private static MyLink<Integer> merge(MyLink<Integer> link1, MyLink<Integer> link2) {
        Node cur1 = link1.head.next;
        Node cur2 = link2.head.next;
        MyLink<Integer> back = new MyLink<>();

        while(cur1!=null && cur2!=null) {
            if((int)cur1.data <= (int)cur2.data){
                back.addLast(new Node(cur1.data));
                cur1 = cur1.next;
            }

            if(cur1 !=null && (int)cur2.data <= (int)cur1.data) {
                back.addLast(new Node(cur2.data));
                cur2 = cur2.next;
            }
        }
        if(cur1!=null) {
            back.addLast(cur1);
        }
        if(cur2 !=null) {
            back.addLast(cur2);
        }
        return back;
    }
}

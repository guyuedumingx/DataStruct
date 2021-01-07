package week_5.wangwei;

import util.wangwei.MyLink;
import util.wangwei.Node;

/**
 * 按自然顺序排序的链表
 * 转换成
 * 奇数倒序在前，偶数顺序在后
 * @author yohoyes
 */
public class OddEvenLink {

    static MyLink<Integer> link = new MyLink<Integer>();

    public static Integer[] createInitArray(int num){
        Integer[] res = new Integer[num];
        for(int i=0; i<num; i++) {
            res[i] = num-i;
        }
        return res;
    }


    public static void main(String[] args) {
        int num = 10;
        link.init(createInitArray(num));
        link.prt();
        for( Node<Integer> cur=link.head;cur.next!=null;cur=cur.next){
            Node<Integer> p = cur.next;
            int res = p.data%2;
            if(res!=0){
                 cur.next = p.next;
                 link.add(p);
                 link.prt();
            }
        }
        link.prt();
        MyLink<Integer> myLink = new MyLink<Integer>();
        back(link.head.next,myLink);
        myLink.prt();
    }

    private static void back(Node<Integer> cur,MyLink<Integer> myLink){
        if(cur==null||cur.data%2==0){
            return;
        }
        back(cur.next,myLink);
        Node<Integer> p = null;
        for(p=myLink.head;p.next!=null;p=p.next){}
        p.next = new Node<Integer>(cur.data);
    }

}

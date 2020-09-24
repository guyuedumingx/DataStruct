package week_3.wangwei;

import java.util.ArrayList;

public class MyLinkDemo {

    public static void main(String[] args) {
        MyLink<Integer> myLink = new MyLink<Integer>();
        myLink.add(0);
        myLink.add(1);
        myLink.add(2);
        myLink.add(3);
        myLink.showData(myLink.head);
    }
}

class MyLink<T> {

    Node head = new Node();

    /**
     * 节点类
     */
    class Node {
        T data;
        Node next;
        public Node() {}
        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * 头插法
     * @param t 传入的数据值
     * @param <T>
     */
    public <T> void add(T t) {
        Node s = new Node(t);
        s.next = head.next;
        head.next = s;
    }

    /**
     * 后序遍历
     * @param n 传入的遍历节点
     */
    public void showData(Node n) {
       if (n==null) {return;}
       showData(n.next);
       System.out.println(n.data);
    }

    /**
     * 后序遍历
     * @param n
     */
    public void dShowData(Node n) {
        if (n==null) {return;}
        System.out.println(n.data);
        showData(n.next);
    }
}

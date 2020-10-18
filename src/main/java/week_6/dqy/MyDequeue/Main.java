package week_6.dqy.MyDequeue;

public class Main {
    public static void main(String[] args) {
        TwoWayList tList = new TwoWayList();
        //处使两个临时变量
        TwoWayList.Node tmp = tList.head;
        TwoWayList.Node last = tList.head.pre;
        for (int i = 1; i <= 10; i++) {
            TwoWayList.Node news = new TwoWayList.Node(i);
            tmp.next = news;
            tmp.pre = last;
            last = tmp;
            tmp = tmp.next;
        }
        //测试各种方法
        tmp = tList.findNthNode(5);
        tList.printList();
        //前加和后加
        TwoWayList.addBefore(tmp,666);
        TwoWayList.addBehind(tmp,999);
        tList.printList();
        //删除前结点
        TwoWayList.deletePreNode(tmp);
        tList.printList();
        //删除后结点
        TwoWayList.deleteNextNode(tmp);
        tList.printList();
        //自己删除自己
        TwoWayList.deleteItself(tmp);
        tList.printList();
    }
}

class TwoWayList {
    //结点类
    static class Node {
        int val;
        Node pre;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }
    }

    Node head = new Node();

    //在结点前添加
    public static void addBefore(Node cur, int val) {
        Node newNode = new Node(val);
        newNode.next = cur;
        newNode.pre = cur.pre;
        newNode.pre.next = newNode;
        newNode.next.pre = newNode;
    }

    //在结点后添加
    public static void addBehind(Node cur, int val) {
        Node newNode = new Node(val);
        newNode.next = cur.next;
        newNode.pre = cur;
        newNode.pre.next = newNode;
        newNode.next.pre = newNode;
    }

    //删除上一个结点
    public static void deletePreNode(Node cur) {
        cur.pre = cur.pre.pre;
        cur.pre.next = cur.pre.next.next;
    }

    //删除下一个结点
    public static void deleteNextNode(Node cur) {
        cur.next = cur.next.next;
        cur.next.pre = cur.next.pre.pre;
    }

    //删除自己
    public static void deleteItself(Node cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
    }

    //输出链表
    public void printList() {
        Node cur = this.head.next;
        while (cur != null) {
            System.out.print(cur.val + "  ");
            cur = cur.next;
        }
        System.out.println();
    }

    //找到第idx个结点
    public Node findNthNode(int idx) {
        Node cur = this.head;
        while (idx-- != 0) {
            cur = cur.next;
        }
        return cur;
    }
}
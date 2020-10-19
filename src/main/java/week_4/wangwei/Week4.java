package week_4.wangwei;


import util.wangwei.Node;
import util.wangwei.MyLink;

/**
 * 第四周作业
 * @author wangwei
 */
public class Week4 {
    static MyLink<Character> link = new MyLink<Character>();

    public static void main(String[] args) {
        Character[] nodes = new Character[]{'a', 'c', 'a', 'g', 'a', 'a', 'a', 'b'};
        link.init(nodes);
        link.prt();
        reverse();
        link.prt();
    }

    /**
     * 在a节点后插入一个节点
     */
    public static void addNodeBehindA() {
        //在a节点后插入的节点
        Node<Character> nodeC = new Node<Character>('c');

        //空链表情况,就是只有一个头指针,头指针的next是null
        if (link.head.next == null) {
            return;
        }
        //指针
        Node<Character> p = link.head.next;

        //找到a节点
        while (p != null && p.data != 'a') {
            p = p.next;
        }
        if (p.data == 'a') {
            nodeC.next = p.next;
            p.next = nodeC;
        }
    }

    /**
     * 在每个a后面添加一个节点
     */
    public static void addNodeBehindAMore() {
        if (link.head.next == null) {
            return;
        }
        //指针
        Node<Character> p = link.head.next;
        while (p != null) {
            if (p.data == 'a') {
                //在a节点后插入的节点
                Node<Character> nodeC = new Node<Character>('c');
                nodeC.next = p.next;
                p.next = nodeC;
            }
            p = p.next;
        }
    }

    /**
     * 在所有a后面添加一个a
     */
    public static void addABehindA() {
        if (link.head.next == null) {
            return;
        }
        //指针
        Node<Character> p = link.head.next;
        while (p != null) {
            if (p.data == 'a') {
                //在a节点后插入的节点
                Node<Character> nodeA = new Node<Character>('a');
                nodeA.next = p.next;
                p.next = nodeA;
                p = p.next;
            }
            if (p.next == null) {
                break;
            }
            p = p.next;
        }
    }

    /**
     * 在所有a前面插入一个节点
     */
    public static void addNodeBeforeA() {
        if (link.head.next == null) {
            return;
        }
        //指针
        Node<Character> p = link.head;
        while (p.next != null) {
            if (p.next.data == 'a') {
                //在a节点后插入的节点
                Node<Character> nodeA = new Node<Character>('z');
                nodeA.next = p.next;
                p.next = nodeA;
                p = p.next;
            }
            p = p.next;
        }
    }

    /**
     * 删除所有的a节点
     */
    public static void deleteAllA() {
        if (link.head.next == null) {
            return;
        }
        Node<Character> p = link.head;
        while (p.next != null) {
            if (p.next.data != 'a') {
                p = p.next;
                continue;
            }
            p.next = p.next.next;
        }
    }

    /**
     * 删除所有a节点前的节点
     */
    public static void deleteNodeBeforeA() {
        if (link.head.next == null) {
            return;
        }
        Node<Character> p = link.head.next;
        while (p.next != null) {
            if (p.next.data != 'a') {
                p = p.next;
                continue;
            }
            p.data = p.next.data;
            p.next = p.next.next;
        }
    }

    /**
     * 删除a节点后的节点
     */
    public static void delNodeAfterA() {
        if (link.head.next == null) {
            return;
        }
        Node<Character> p = link.head.next;
        while (p != null) {
            if (p.data == 'a' && p.next != null) {
                p.next = p.next.next;
            }
            p = p.next;
        }
    }

    /**
     * 合并两链表
     */
    public static void merge() {
        Character[] nodesA = new Character[]{'q', 'm', 'h', 'g', 'f', 'd', 'c', 'a'};
        MyLink<Character> linkA = new MyLink<Character>();
        linkA.init(nodesA);
        linkA.prt();
        Character[] nodesB = new Character[]{'r', 'n', 'l', 'k', 'j', 'i', 'f', 'e'};
        MyLink<Character> linkB = new MyLink<Character>();
        linkB.init(nodesB);
        linkB.prt();
        Node<Character> p = linkA.head.next;
        Node<Character> q = linkB.head;

        while (p != null && q.next != null) {
            if (p.data <= q.next.data) {
                Node<Character> tmp = new Node<Character>(p.data);
                tmp.next = q.next;
                q.next = tmp;
                p = p.next;
            }
            q = q.next;
        }
        if (q.next == null) {
            q.next = p;
        }
        linkB.prt();
    }

    /**
     * 拆分链表
     */
    public static void div() {
        Integer[] nodes = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MyLink<Integer> myLink = new MyLink<Integer>();
        myLink.init(nodes);
        link.prt();
        MyLink<Integer> resA = new MyLink<Integer>();
        MyLink<Integer> resB = new MyLink<Integer>();
        Node<Integer> p = myLink.head.next;
        while (p != null) {
            Node<Integer> tmp = new Node<Integer>(p.data);
            if (p.data % 2 == 0) {
                tmp.next = resB.head.next;
                resB.head.next = tmp;
            } else {
                tmp.next = resA.head.next;
                resA.head.next = tmp;
            }
            p = p.next;
        }
        resA.prt();
        resB.prt();
    }

    /**
     * 循环交换两节点位置
     */
    public static void chPos() {
        Character[] nodes = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        link.init(nodes);
        link.prt();
        Node<Character> p = link.head;
        while (p.next != null && p.next.next != null) {
            Node<Character> a = p.next;
            Node<Character> b = p.next.next;
            a.next = a.next.next;
            b.next = a;
            p.next = b;
            p = a;
        }
        link.prt();
    }

    /**
     * 单链表逆序
     */
    public static void reverse() {
        Node<Character> pre = null;
        Node<Character> temp = null;
        Node<Character> cur = link.head.next;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        link.head.next = pre;
    }
}


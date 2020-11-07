package week_6.dqy.addtofront;

public class Main {
    public static void main(String[] args) {
        int idx = 1, add = 2;
        MyList list = new MyList();
        MyList.Node cur = list.head;
        for (int i = 1; i <= 100; i++) {
            MyList.Node newNode = new MyList.Node(i);
            list.addToBack(newNode);
        }
        list.printList();
        //添加的位置在范围内
        while (idx < 100) {
            //减去最后的结点
            MyList.Node lastNode = list.deleteNode(100);
            //添加到相应的结点后
            MyList.Node nthNode = list.getNthNode(idx);
            lastNode.next = nthNode.next;
            nthNode.next = lastNode;
            idx += add;
            add++;
        }
        System.out.println();
        list.printList();
    }
}

class MyList {
    static class Node {
        int data;
        MyList.Node next;

        //无参构造
        public Node() {
        }

        //有参构造
        public Node(int data) {
            this.data = data;
        }
    }

    public MyList.Node head = new MyList.Node();
    public MyList.Node last = head;

    //输出链表
    public void printList() {
        MyList.Node n = this.head.next;
        //判断当前结点是否为空就输出
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    //获取链表长度
    public int getSize() {
        MyList.Node tmp = this.head.next;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return len;
    }

    //获取第n个结点
    public MyList.Node getNthNode(int idx) {
        MyList.Node tmp = this.head;
        while (idx > 0) {
            tmp = tmp.next;
            idx--;
        }
        return tmp;
    }

    //交换j后的两个相邻节点
    public void swap(int j) {
        //获取j结点
        MyList.Node nodeJ = getNthNode(j);
        MyList.Node pre = nodeJ.next;
        MyList.Node ne = pre.next;
        //开始交换
        nodeJ.next = ne;
        pre.next = ne.next;
        ne.next = pre;
    }

    //删除节点
    public MyList.Node deleteNode(int i) {
        MyList.Node pre = this.getNthNode(i - 1);
        MyList.Node cur = new MyList.Node(this.getNthNode(i).data);
        pre.next = pre.next.next;
        return cur;
    }

    //在头部添加结点
    public void addForward(MyList.Node v) {
        v.next = head.next;
        head.next = v;
    }

    //尾部添加
    public void addToBack(MyList.Node v) {
        Node tmp = this.head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        last = v;
        tmp.next = v;
    }
}
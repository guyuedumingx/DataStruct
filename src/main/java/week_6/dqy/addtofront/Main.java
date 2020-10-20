package week_6.dqy.addtofront;

public class Main {
    public static void main(String[] args) {

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

    MyList.Node head = new MyList.Node();

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
}
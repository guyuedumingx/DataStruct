package util.dqy;

public class QyList<T> {
    class Node<T> {
        T data;
        Node next;

        //有参构造
        public Node(T data) {
            this.data = data;
        }
    }

    public Node head = new Node(null);

    //输出链表
    public void printList() {
        Node n = this.head.next;
        //判断当前结点是否为空就输出
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    //获取链表长度
    public int getSize() {
        Node tmp = this.head.next;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return len;
    }

    //获取最后一个结点
    public int getLast() {
        Node tmp = this.head.next;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return len;
    }

    //获取第n个结点
    public Node getNthNode(int idx) {
        Node tmp = this.head;
        while (idx > 0) {
            tmp = tmp.next;
            idx--;
        }
        return tmp;
    }

    //删除节点
    public Node deleteNode(int i) {
        Node pre = this.getNthNode(i - 1);
        Node cur = new Node(this.getNthNode(i).data);
        pre.next = pre.next.next;
        return cur;
    }

    //在头部添加结点
    public void addForward(Node v) {
        v.next = head.next;
        head.next = v;
    }
}

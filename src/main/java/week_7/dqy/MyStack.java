package week_7.dqy;

import util.dqy.QyQueue;

public class MyStack {
    static class Node {
        private int data;
        private Node next;

        //有参构造
        public Node(int data) {
            this.data = data;
        }
    }

    Node head = new Node(0);

    //压栈
    public void push(int v) {
        Node tmp = new Node(v);
        tmp.next = head.next;
        head.next = tmp;
    }

    //获取栈顶元素
    public int getTop() {
        return head.next.data;
    }

    //弹出栈
    public void pop() {
        if (head.next != null)
            head.next = head.next.next;
    }

    //判断是否为空
    public boolean isEmpty() {
        if (head.next == null)
            return true;
        return false;
    }

    //获取队列的大小
    public int size() {
        Node cur = this.head.next;
        int s = 0;
        while (cur != null) {
            cur = cur.next;
            s++;
        }
        return s;
    }
}
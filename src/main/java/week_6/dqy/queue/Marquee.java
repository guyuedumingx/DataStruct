package week_6.dqy.queue;

public class Marquee {
    public static void main(String[] args) {
        //测试队列
        MyQueue q = new MyQueue();
        q.push(12);
        q.push(15);
        System.out.println(q.getFront());
        q.pop();
        System.out.println(q.getFront());
    }
}


class MyQueue {
    static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }
    }

    //一个指头，一个指尾
    Node head = new Node();
    Node last = head;

    //压入队列
    public void push(int num) {
        Node news = new Node(num);
        last.next = news;
        last = news;
    }

    //弹出元素
    public void pop() {
        if (head.next != null)
            head.next = head.next.next;
    }

    //获取前面的元素
    public int getFront() {
        return  head.next.val;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        if (head.next == null)
            return false;
        else
            return true;
    }
}

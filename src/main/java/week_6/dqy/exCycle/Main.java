package week_6.dqy.exCycle;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CycleList ans = CycleList.makeCycle(200);
        int left = ans.weedOut(200, 6);
        ans.printSurvivor(left);
    }
}

class CycleList {
    static class Node {
        int data;
        CycleList.Node next;

        //无参构造
        public Node() {
        }

        //有参构造
        public Node(int data) {
            this.data = data;
        }
    }

    CycleList.Node head = new CycleList.Node();

    //输出链表
    public void printList() {
        CycleList.Node n = this.head.next;
        //判断当前结点是否为空就输出
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    //获取链表长度
    public int getSize() {
        CycleList.Node tmp = this.head.next;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return len;
    }

    //获取第n个结点
    public CycleList.Node getNthNode(int idx) {
        CycleList.Node tmp = this.head;
        while (idx > 0) {
            tmp = tmp.next;
            idx--;
        }
        return tmp;
    }

    //交换j后的两个相邻节点
    public void swap(int j) {
        //获取j结点
        CycleList.Node nodeJ = getNthNode(j);
        CycleList.Node pre = nodeJ.next;
        CycleList.Node ne = pre.next;
        //开始交换
        nodeJ.next = ne;
        pre.next = ne.next;
        ne.next = pre;
    }

    //删除节点
    public CycleList.Node deleteNode(int i) {
        CycleList.Node pre = this.getNthNode(i - 1);
        CycleList.Node cur = new CycleList.Node(this.getNthNode(i).data);
        pre.next = pre.next.next;
        return cur;
    }

    //在头部添加结点
    public void addForward(CycleList.Node v) {
        v.next = head.next;
        head.next = v;
    }

    //约瑟夫环
    //制作一个循环链表
    public static CycleList makeCycle(int n) {
        CycleList curList = new CycleList();
        CycleList.Node cur = curList.head;
        for (int i = 1; i <= n; i++) {
            cur.next = new CycleList.Node(i);
            cur = cur.next;
        }
        cur.next = curList.head.next;
        return curList;
    }

    //处理出局
    public int weedOut(int n, int step) {
        int idx = n, sum = n;
        CycleList.Node cur = this.head.next;
        //剩下8个人时结束
        while (n >= 8) {
            int times = n / step;
            int curTime = 0;
            while (curTime < times) {
                int t = step - 1;
                while (t-- != 0) {
                    cur = cur.next;
                }
                //判断当前点是否
                int ran = new Random().nextInt(10);
                if(ran >= 2) {
                    cur.next = cur.next.next;
                    n--;
                    curTime++;
                }
            }
            //随机加入n个人
            int addNum = new Random().nextInt(3) + 5;
            for (int i = 0;i < addNum; i++) {
                Node peo = new Node(idx++);
                peo.next = this.head.next.next;
                this.head.next.next = peo;
            }
        }
        //剩下的人数
        return n;
    }

    //输出最后幸存的人
    public void printSurvivor(int n) {
        Node cur = this.head.next;
        for (int i = 0; i < n; i++) {
            System.out.print(cur.data + "  ");
            cur = cur.next;
        }
    }
}
package week_5.dqy;

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

    Node head = new Node();

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
        Node tmp = this.head.next;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return len;
    }

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

    //交换j后的两个相邻节点
    public void swap(int j) {
        //获取j结点
        Node nodeJ = getNthNode(j);
        Node pre = nodeJ.next;
        Node ne = pre.next;
        //开始交换
        nodeJ.next = ne;
        pre.next = ne.next;
        ne.next = pre;
    }

    //冒泡排序
    public void bubbleSort() {
        //获取数组长度
        int n = this.getSize();
        for (int i = 1; i <= n - 1; i++) {
            for (int j = n; j > i; j--) {
                Node cur = this.getNthNode(j);
                Node cmp = this.getNthNode(j - 1);
                if (cur.data < cmp.data) {
                    swap(j - 2);
                }
            }
        }
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

    //奇前偶后链表
    public void turnList() {
        MyList tmp = new MyList();
        Node cur = this.head;
        int i = 1;
        while (cur.next != null) {
            //判断当前数据是奇数还是偶数
            if (cur.next.data % 2 == 0) {
                Node temp = this.deleteNode(i);
                tmp.addForward(temp);
            }
            cur = cur.next;
            i++;
        }
        cur.next = tmp.head.next;
        tmp.head = null;
    }

    //将奇前偶后链表还原
    public MyList turnBack() {
        //创建一个新的链表
        MyList newList = new MyList();
        if (this.head.next == null) return newList;
        Node even = this.head;
        Node odd = this.head;
        //找到尾部结点
        
        return newList;
    }

    //约瑟夫环
    //制作一个循环链表
    public static MyList makeCycle(int n) {
        MyList curList = new MyList();
        Node cur = curList.head;
        for (int i = 1; i <= n; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = curList.head.next;
        return curList;
    }

    //处理出局
    public int weedOut(int n, int step) {
        Node cur = this.head.next;
        while (n != 1) {
            int t = step - 1;
            while (t-- != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            n--;
        }
        return cur.data;
    }

    //
}

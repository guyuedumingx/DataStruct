package week_6.dqy.rangeList;

class rList {
    static class Node {
        int data;
        rList.Node next;

        //无参构造
        public Node() {
        }

        //有参构造
        public Node(int data) {
            this.data = data;
        }
    }

    rList.Node head = new rList.Node();

    //输出链表
    public void printList() {
        rList.Node n = this.head.next;
        //判断当前结点是否为空就输出
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    //获取链表长度
    public int getSize() {
        rList.Node tmp = this.head.next;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return len;
    }

    //获取第n个结点
    public rList.Node getNthNode(int idx) {
        rList.Node tmp = this.head;
        while (idx > 0) {
            tmp = tmp.next;
            idx--;
        }
        return tmp;
    }

    //交换j后的两个相邻节点
    public void swap(int j) {
        //获取j结点
        rList.Node nodeJ = getNthNode(j);
        rList.Node pre = nodeJ.next;
        rList.Node ne = pre.next;
        //开始交换
        nodeJ.next = ne;
        pre.next = ne.next;
        ne.next = pre;
    }

    //删除节点
    public rList.Node deleteNode(int i) {
        rList.Node pre = this.getNthNode(i - 1);
        rList.Node cur = new rList.Node(this.getNthNode(i).data);
        pre.next = pre.next.next;
        return cur;
    }

    //在头部添加结点
    public void addForward(rList.Node v) {
        v.next = head.next;
        head.next = v;
    }
}

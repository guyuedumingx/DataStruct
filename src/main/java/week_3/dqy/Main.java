package week_3.dqy;

public class Main {
    public static void main(String[] args) {
        MyLink list = new MyLink();
        MyLink.Node tmp = list.head;
        for (int i = 1; i < 10; i++) {
            tmp.next = new MyLink.Node(i);
            tmp = tmp.next;
        }
        list.searchFromBeginning(list.head.next);
        System.out.println();
        list.searchFromBack(list.head.next);
        System.out.println();
        list.addForward(0);
        list.addLast(11);
        list.searchFromBeginning(list.head.next);
        System.out.println();
        list.searchFromBack(list.head.next);
        System.out.println();
        list.disSearch(list.head.next);
    }
}

class MyLink {

    //结点类
    static class Node {
        int data;
        Node next;

        //无参构造
        public Node() {
        }

        //有参构造
        public Node(int data) {
            this.data = data;
        }
    }

    //生成一个头结点
    Node head = new Node();

    //从前面开始插入结点
    public void addForward(int v) {
        Node cur = new Node(v);
        cur.next = head.next;
        head.next = cur;
    }

    //从后面开始插入结点
    public void addLast(int v) {
        Node root = head;
        while (root.next != null) {
            root = root.next;
        }
        root.next = new Node(v);
    }

    //压栈后从后往前遍历
    public void searchFromBack(Node n) {
        if (n == null) {
            return;
        }
        searchFromBack(n.next);
        System.out.print(n.data + " ");
    }

    //从前往后递归遍历
    public void searchFromBeginning(Node n) {
        if (n == null) {
            return;
        }
        System.out.print(n.data + " ");
        searchFromBeginning(n.next);
    }

    //相隔两位遍历
    public void disSearch(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            if (n.next == null) break;
            n = n.next.next;
        }
    }

}

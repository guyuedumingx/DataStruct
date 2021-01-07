package week_3.wangwei;

/**
 * 第三周作业
 * @author wangwei
 */
public class MyLinkDemo {

    public static void main(String[] args) {
        MyLink<Integer> myLink = new MyLink<Integer>();
        myLink.add(40);
        myLink.add(30);
        myLink.add(20);
        myLink.add(10);
        myLink.addLast(50);
        myLink.addLast(90);
        myLink.addLast(500);
        myLink.distantIterator();
    }
}

class MyLink<T> {

    Node<T> head = new Node<T>();

    /**
     * 节点类
     */
    class Node<T> {
        T data;
        Node next;
        public Node() {}
        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * 头插法
     * @param t 传入的数据值
     */
    public void add(T t) {
        Node s = new Node(t);
        s.next = head.next;
        head.next = s;
    }

    /**
     *尾插法
     * @param t
     */
    public void addLast(T t) {
        Node<T> root = head;
        while(root.next!=null) {
            root = root.next;
        }
        root.next = new Node(t);
    }

    /**
     * 后序遍历递归法
     * @param n 传入的遍历节点
     */
    public void dfs(Node n) {
       if (n==null) {return;}
       dfs(n.next);
       System.out.println(n.data);
    }

    /**
     * 先序遍历递归法
     * @param n
     */
    public void bfs(Node n) {
        if (n==null) {return;}
        System.out.println(n.data);
        bfs(n.next);
    }

    /**
     * 迭代法先序遍历
     */
    public void showDataIterator() {
        Node<T> root = head.next;
        while (root!=null) {
            System.out.println(root.data);
            root = root.next;
        }
    }

    /**
     * 隔位迭代遍历链表
     */
    public void distantIterator() {
        Node<T> root = head.next;
        while (root!=null) {
            System.out.println(root.data);
            root = root.next;
            if(root==null){
                return;
            }
            root = root.next;
        }
    }
}

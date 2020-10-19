package week_5.wangwei;

public class BothWayLink<T> {
    public Node<T> head = new Node<T>();

    /**
     * 初始化数组
     * @param list
     */
    public void init(T[] list){
        head.next = null;
        for (T n : list){
        }
    }

    /**
     * 头插
     * @param n
     */
    public void addHead(T n){
        Node<T> node = new Node<T>(n);
        node.next = head.next;
        if(head.next!=null){
            node.next.pre = node;
        }
        node.pre = head;
    }

    /**
     * 在第一个n节点前加入data节点
     * @param n
     * @param data
     */
    public void addBefore(T n, T data) {
        Node<T> cur = head.next;
        while (cur.data!=n) {
            cur=cur.next;
        }
        Node<T> node = new Node<T>(data);
        node.pre = cur.pre;
        cur.pre.next = node;
        cur.pre = node;
        node.next = cur;
    }

    /**
     * 在第一个n节点后加入data节点
     * @param n
     * @param data
     */
    public void addBehind(T n, T data){
        Node<T> cur = head.next;
        while (cur.data!=n) {
            cur=cur.next;
        }
        Node<T> node = new Node<T>(data);
        node.next = cur.next;
        cur.next.pre = node;
        cur.next = node;
        node.pre = cur;
    }

    /**
     * 删除n节点前一个节点
     * @param n
     */
    public void delBefore(T n){
        Node<T> cur = head.next;
        while (cur.data!=n) {
            cur=cur.next;
        }
        cur.pre = cur.pre.pre;
        cur.pre.next = cur;
    }

    /**
     * 删除节点后一个节点
     * @param n
     */
    public void delBehind(T n) {
        Node<T> cur = head.next;
        while (cur.data!=n) {
            cur=cur.next;
        }
        if(cur.next==null){
            return;
        }
        cur.next = cur.next.next;
        cur.next.pre = cur;
    }

    /**
     * 删除自己
     * @param n
     */
    public void delSelf(T n){
        Node<T> cur = head.next;
        while (cur.data!=n) {
            cur=cur.next;
        }
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
    }

    /**
     * 打印链表
     */
    public void prt(){
        //空链表情况,就是只有一个头指针,头指针的next是null
        if(this.head.next == null){return;}
        //指针
        Node<T> p = this.head.next;
        System.out.print("head");
        while(p!=null){
            System.out.print(" -> "+p.data);
            p = p.next;
        }
        System.out.println();
    }

}

class Node<T> {
    T data;
    Node<T> pre;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public Node(){}
}

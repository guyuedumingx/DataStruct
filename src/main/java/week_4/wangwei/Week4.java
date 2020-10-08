package week_4.wangwei;

/**
 * 基本链表
 */
class MyLink<T> {
    /**
     * 头节点
     */
    public Node<T> head = new Node<T>();
}

/**
 * 节点类
 * @param <T>
 */
class Node<T> {
    T data;
    Node<T> next;
    public Node(T data){this.data = data;}
    public Node(){}
}

/**
 * 第四周作业
 * @author wangwei
 */
public class Week4{
    static MyLink<Character> link = new MyLink<Character>();

    public static void main(String[] args) {
        addNodeBehindA();
    }

    /**
     * 在a节点后插入一个节点
     */
    public static void addNodeBehindA(){
        //初始化link
        link.head.next = null;
        Node<Character> nodeB = new Node<Character>('b');
        Node<Character> nodeA = new Node<Character>('a');
        link.head.next = nodeB;
        nodeB.next = nodeA;
        // head -> b -> a

        //在a节点后插入的节点
        Node<Character> nodeC = new Node<Character>('c');

        //空链表情况,就是只有一个头指针,头指针的next是null
        if(link.head.next == null){return;}
        //指针
        Node<Character> p = link.head.next;

        //找到a节点
        while(p!=null&& p.data!='a'){
            p = p.next;
        }
        if(p.data=='a'){
            p.next = nodeC;
        }
        prtLink(link);
    }

    /**
     * 打印链表
     * @param link
     */
    public static void prtLink(MyLink link){
        //空链表情况,就是只有一个头指针,头指针的next是null
        if(link.head.next == null){return;}
        //指针
        Node<Character> p = link.head.next;
        System.out.print("head");
        while(p!=null){
            System.out.print(" -> "+p.data);
            p = p.next;
        }
    }
}


package util.wangwei;

public class CircularLink<T> extends MyLink<T>{

    /**
     * 头插法
     * @param n
     */
    @Override
    public void add(T n) {
        super.add(n);
        if(head.next.next==null){
            head.next.next = head;
        }
    }

    /**
     * 打印链表
     */
    @Override
    public void prt(){
        //空链表情况,就是只有一个头指针,头指针的next是null
        if(this.head.next == null){return;}
        //指针
        Node<T> p = this.head.next;
        System.out.print("head");
        while(p!=this.head){
            System.out.print(" -> "+p.data);
            p = p.next;
        }
        System.out.println();
    }
}

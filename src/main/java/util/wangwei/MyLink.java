package util.wangwei;

import java.lang.reflect.Field;

/**
 * 基本链表
 */
public class MyLink<T> {
        /**
         * 头节点
         */
        public Node<T> head = new Node<T>();

        /**
         * 头插法
         */
        public void add(T n){
            Node<T> node = new Node<T>(n);
            node.next = head.next;
            head.next = node;
        }
        /**
         * 头插法
         */
        public void add(Node<T> node){
            node.next = head.next;
            head.next = node;
        }

        /**
         *尾插法
         * @param t
         */
        public void addLast(T t) {
            Node node = head;
            while(node.next!=null) {
                node = node.next;
            }
            node.next = new Node(t);
        }

    /**
     * 初始化数组
     * @param list
         */
        public void init(T[] list){
            head.next = null;
            for (T n : list){
                this.add(n);
            }
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

        public void prt(String name){
            //空链表情况,就是只有一个头指针,头指针的next是null
            if(this.head.next == null){return;}
            //指针
            Node<T> p = this.head.next;
            System.out.print("head");
            while(p!=null){
                try {
                    Field field = p.data.getClass().getDeclaredField(name);
                    field.setAccessible(true);
                    System.out.print(" -> "+field.get(p.data));
                    p = p.next;
                }catch (Exception e){
                    throw new RuntimeException("没有这个字段");
                }
            }
            System.out.println();
        }
}

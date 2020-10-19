package util.wangwei;

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

    }

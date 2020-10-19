package week_4.dqy;

public class Main {
    public static void main(String[] args) {
        MyLink list1 = new MyLink();
        MyLink.Node tmp1 = list1.head;
        for (int i = 1; i < 10; i++) {
            tmp1.next = new MyLink.Node(i);
            tmp1 = tmp1.next;
        }
        MyLink list2 = new MyLink();
        MyLink.Node tmp2 = list2.head;
        for (int i = 1; i < 10; i++) {
            tmp2.next = new MyLink.Node(i);
            tmp2 = tmp2.next;
        }
        list1.searchFromBeginning(list1.head.next);
        System.out.println();
        list1.searchFromBeginning(list2.head.next);
        System.out.println();
        MyLink ans = MyLink.mergeLink(list1, list2);
        ans.searchFromBeginning(ans.head.next);
    }
}

class MyLink {
    //结点类
    static class Node {
        int data;
        MyLink.Node next;

        //无参构造
        public Node() {
        }

        //有参构造
        public Node(int data) {
            this.data = data;
        }
    }

    //生成一个头结点
    MyLink.Node head = new MyLink.Node();

    //从前面开始插入结点
    public void addForward(int v) {
        MyLink.Node cur = new MyLink.Node(v);
        cur.next = head.next;
        head.next = cur;
    }

    //从后面开始插入结点
    public void addLast(int v) {
        MyLink.Node cur = head;
        //寻找最后一个节点
        while (cur.next != null) {
            cur = cur.next;
        }
        //在最后一个结点后加一个结点
        cur.next = new MyLink.Node(v);
    }

    //压栈后从后往前遍历
    public void searchFromBack(MyLink.Node n) {
        //判断当前点是否为空
        if (n == null) {
            return;
        }
        searchFromBack(n.next);
        System.out.print(n.data + " ");
    }

    //从前往后递归遍历
    public void searchFromBeginning(MyLink.Node n) {
        //判断当前结点是否为空
        if (n == null) {
            return;
        }
        //输出当前结点
        System.out.print(n.data + " ");
        //搜索下一个结点
        searchFromBeginning(n.next);
    }

    //相隔两位遍历
    public void disSearch(MyLink.Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            if (n.next == null) break;
            n = n.next.next;
        }
    }

    //weak4任务

    //在一个a后面插入节点
    public void insertBack(int num) {
        Node cur = head.next;
        while (cur != null) {
            if (cur.data == num) {
                Node newNode = new Node(666);
                newNode.next = cur.next;
                cur.next = newNode;
                break;
            }
            cur = cur.next;
        }
    }

    //在每个a后面插入节点
    public void insertEveryBack(int num) {
        Node cur = head.next;
        while (cur != null) {
            if (cur.data == num) {
                Node newNode = new Node(666);
                newNode.next = cur.next;
                cur.next = newNode;
            }
            cur = cur.next;
        }
    }

    //在a后面复制一个a节点
    public void copyNode(int num) {
        Node cur = head.next;
        while (cur != null) {
            if (cur.data == num) {
                Node newNode = new Node(cur.data);
                newNode.next = cur.next;
                cur.next = newNode;
                cur = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
    }

    //在a前面插一个节点
    public void insertBefore(int num) {
        Node cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.data == num) {
                Node newNode = new Node(666);
                newNode.next = cur.next;
                cur.next = newNode;
                cur = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
    }

    //删除a节点
    public void delete(int num) {
        Node cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.data == num) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
    }

    //删除a后的节点
    public void deletePNextNode(int num) {
        Node cur = head;
        while (cur != null && cur.next != null) {
            if (cur.data == num) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
    }

    //删除a前的节点
    public void deletePreNode(int num) {
        Node cur = head;
        while (cur != null && cur.next != null && cur.next.next != null) {
            if (cur.next.next.data == num) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
    }

    //根据步长为二交换元素
    public void exchangeNode() {
        Node cur = head;
        while (cur != null && cur.next != null && cur.next.next != null) {
            Node tmp = cur.next.next.next;
            cur.next.next.next = cur.next;
            cur.next = cur.next.next;
            cur.next.next.next = tmp;
            cur = cur.next.next;
        }
    }

    //反转链表
    public void reverse() {
        Node temp, pre = null, cur = this.head.next;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        this.head.next = pre;
    }

    //拆分链表
    public static MyLink[] splitLink(MyLink oldLink) {
        MyLink[] newLinks = new MyLink[2];
        newLinks[0] = new MyLink();
        newLinks[1] = new MyLink();
        Node cur = oldLink.head;
        while (cur != null) {
            Node tmp = cur.next;
            if (cur.data % 2 == 0) {
                Node newTmp = newLinks[0].head;
                while (newTmp.next != null) {
                    newTmp = newTmp.next;
                }
                cur.next = null;
                newTmp.next = cur;
            } else {
                Node newTmp = newLinks[1].head;
                while (newTmp.next != null) {
                    newTmp = newTmp.next;
                }
                cur.next = null;
                newTmp.next = cur;
            }
            cur = tmp;
        }
        return newLinks;
    }

    //合并链表
    public static MyLink mergeLink(MyLink l1, MyLink l2) {
        MyLink tmp = new MyLink();
        Node idxL1 = l1.head.next, idxL2 = l2.head.next;
        Node last = tmp.head;
        while (idxL1 != null && idxL2 != null) {
            Node temp1 = idxL1.next,temp2 =idxL2.next;
            last.next = idxL1;
            idxL1.next = idxL2;
            idxL2.next = null;
            last = idxL2;
            idxL1 = temp1;
            idxL2 = temp2;
        }
        if (idxL1 != null) {
            last.next = idxL1;
            while (last.next != null) {
                last = last.next;
            }
        }
        if (idxL2 != null) {
            last.next = idxL2;
        }
        return tmp;
    }

    //多项式
//    public int sum() {
//
//    }
}
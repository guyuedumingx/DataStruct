package week_5.dqy;

import week_5.dqy.MyList;

public class Main {
    public static void main(String[] args) {
        MyList list1 = new MyList();
        MyList.Node tmp1 = list1.head;
        for (int i = 10; i > 0; i--) {
            tmp1.next = new MyList.Node(i);
            tmp1 = tmp1.next;
        }
        list1.printList();
        System.out.println();
        //冒泡排序
//        list1.bubbleSort();
//        list1.printList();
//        System.out.println();
        //奇前偶后
        list1.turnList();
        list1.printList();
        System.out.println();
        MyList list2 = list1.turnBack();
        list2.printList();
        System.out.println();
        //约瑟夫环
//        MyList cycleList = MyList.makeCycle(100);
//        int ans = cycleList.weedOut(100, 3);
//        System.out.println(ans);
        //测试栈
//        MyStack st = new MyStack();
//        st.push(20);
//        st.push(10);
//        System.out.println(st.getTop());
//        st.pop();
//        System.out.println(st.getTop());
    }
}

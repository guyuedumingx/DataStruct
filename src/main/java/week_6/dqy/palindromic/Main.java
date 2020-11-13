package week_6.dqy.palindromic;

import week_6.dqy.MyStack;

import java.util.Scanner;

//用栈的实现方法
public class Main {

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        //输入字符串
        String str = src.nextLine();
        char[] newStr = str.toCharArray();
        MyStack st = new MyStack();
        int i = 0;
        //先把半数的字符压入栈中
        for (; i < str.length() / 2; i++) {
            st.push(newStr[i]);
        }
        //奇数回文需要跳一格
        if (str.length() % 2 != 0) i++;
        //判断匹配
        while (!st.isEmpty()) {
            if (st.getTop() != newStr[i++]) {
                System.out.println("不匹配");
                return;
            }
            st.pop();
        }
        System.out.println("匹配");
    }
}

//双指针的实现方法
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner src = new Scanner(System.in);
//        //输入字符串
//        String str = src.nextLine();
//        char[] newStr = str.toCharArray();
//        //左右双指针分别指向两头
//        int l = 0, r = str.length() - 1;
//        //两边从中间匹配
//        while (l < r){
//            if (newStr[l++] != newStr[r--]) {
//                System.out.println("不匹配");
//                return;
//            }
//        }
//        System.out.println("匹配");
//    }
//}
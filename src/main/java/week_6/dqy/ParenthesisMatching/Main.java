package week_6.dqy.ParenthesisMatching;

import week_6.dqy.MyStack;

import java.util.Scanner;

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
        if (str.length() % 2 != 0) i++;
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

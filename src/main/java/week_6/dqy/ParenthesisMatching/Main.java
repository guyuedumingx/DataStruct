package week_6.dqy.ParenthesisMatching;

import week_6.dqy.MyStack;

import java.util.Scanner;

//用栈判断左右括号是否匹配
public class Main {

    public static boolean judge(char c) {
        return c == '{' || c == '[' || c == '(';
    }

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        //输入字符串
        String str = src.nextLine();
        char[] newStr = str.toCharArray();
        //创建栈
        MyStack st = new MyStack();
        //从前往后遍历
        for(int i = 0; i < str.length(); i++) {
            //判断当前是左括号还是右括号
            if (judge(newStr[i])) {
                //左括号压栈
                st.push(newStr[i]);
                //右括号判断
            } else {
                //先判断是否存在左括号
                if (st.isEmpty()) {
                    System.out.println("不匹配");
                    return;
                }
                //再看看是否左右括号匹配
                int std = st.getTop();
                if (newStr[i] - std <= 2) {
                    st.pop();
                } else {
                    System.out.println("不匹配");
                    return;
                }
            }
        }
        System.out.println("匹配");
    }
}

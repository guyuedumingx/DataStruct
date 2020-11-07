package week_7.dqy;

import java.util.Scanner;

public class SortByStack {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        String str = src.nextLine();
        System.out.println(str);
        String ans = SortStack.sortNum(str);
        System.out.println(ans);
    }
}

//利用栈恢复原来应该有顺序
class SortStack {
    public static String sortNum(String str) {
        char[] tmp = str.toCharArray();
        //创建两个栈来排序
        MyStack pst = new MyStack(), rst = new MyStack();
        pst.push(tmp[0]);
        for (int i = 1; i < str.length(); i++) {
            //弹出比当前数字小的数字
            while (!pst.isEmpty()) {
                if (pst.getTop() < tmp[i]) {
                    rst.push(pst.getTop());
                    pst.pop();
                } else {
                    break;
                }
            }
            pst.push(tmp[i]);
            //把弹出元素返回
            while (!rst.isEmpty()) {
                pst.push(rst.getTop());
                rst.pop();
            }
        }
        //把栈的元素到数组中形成字符串
        char[] ans = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ans[i] = (char)pst.getTop();
            pst.pop();
        }
        return new String(ans);
    }
}
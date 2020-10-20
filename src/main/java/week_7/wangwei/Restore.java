package week_7.wangwei;

import util.wangwei.MyStack;

/**
 * 还原字母顺序
 * @author yohoyes
 */
public class Restore {
    static MyStack<Character> stackA = new MyStack<Character>();
    static MyStack<Character> stackB = new MyStack<Character>();

    public static String restore(String str){
        //获取字符串的char数组
        char[] chars = str.toCharArray();
        //遍历char数组
        for(char ch : chars){
            //如果StackA不是空,同时ch大于stackA的栈顶元素
            //把栈顶元素移到stackB
            while (stackA.peek()!=null&&stackA.peek()<ch){
                stackB.push(stackA.pop());
            }
            stackA.push(ch);
            //把所有的StackB栈内元素移回stackA
            while (!stackB.isEmpty()){
                stackA.push(stackB.pop());
            }
        }
        //输出stackA
        StringBuilder sb = new StringBuilder();
        while (!stackA.isEmpty()){
            sb.append(stackA.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = restore("BDACE");
        System.out.println(str);
    }
}

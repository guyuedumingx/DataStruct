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
        char[] chars = str.toCharArray();
        for(char ch : chars){
            while (stackA.peek()!=null&&stackA.peek()<ch){
                stackB.push(stackA.pop());
            }
            stackA.push(ch);
            while (!stackB.isEmpty()){
                stackA.push(stackB.pop());
            }
        }
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

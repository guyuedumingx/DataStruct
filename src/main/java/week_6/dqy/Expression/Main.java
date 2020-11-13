package week_6.dqy.Expression;

import week_6.dqy.MyStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        String str = src.nextLine();
        System.out.println(Exp.cal(str));
    }
}

class Exp {

    static int[] idx = new int[128];
    static int[][] theMap = new int[128][];
    public static int cal(String exp) {
        int cur = 0;
        MyStack num = new MyStack();
        char[] expression = exp.toCharArray();
        for (int i = 0; i < expression.length; i++) {
            //判断当前的字符是数字还是运算符
            //是数字的情况
            if (expression[i] >= '0' && expression[i] <= '9') {
                cur *= 10;
                cur += expression[i] - '0';
                //空格分隔的情况
            } else if (expression[i] == ' ') {
                if (expression[i - 1] != '+' && expression[i - 1] != '-' && expression[i - 1] != '*' && expression[i - 1] != '/')
                    num.push(cur);
                cur = 0;
                //加号的情况
            } else if (expression[i] == '+') {
                int addNum1 = num.getTop();
                num.pop();
                int addNum2 = num.getTop();
                num.pop();
                num.push(addNum1 + addNum2);
                //减号的情况
            } else if (expression[i] == '-') {
                int addNum1 = num.getTop();
                num.pop();
                int addNum2 = num.getTop();
                num.pop();
                num.push(addNum1 - addNum2);
                //乘号的情况
            } else if (expression[i] == '*') {
                int addNum1 = num.getTop();
                num.pop();
                int addNum2 = num.getTop();
                num.pop();
                num.push(addNum1 * addNum2);
                //除号的情况
            } else if (expression[i] == '/') {
                int addNum1 = num.getTop();
                num.pop();
                int addNum2 = num.getTop();
                num.pop();
                num.push(addNum1 / addNum2);
            }
        }
        return num.getTop();
    }

    //创建映射
    public static void createIdx() {
        idx['+'] = 0;
        idx['-'] = 1;
        idx['*'] = 2;
        idx['/'] = 3;
        idx['('] = 4;
        idx[')'] = 5;
        idx['#'] = 6;
    }

    public static void createMap() {

    }

    public static String turn() {
        return null;
    }
}
package week_6.dqy.correctSequence;

import week_6.dqy.MyStack;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int n, idx = 0;
    public static int[] ans = new int[10];
    public static boolean[] used = new boolean[10];
    public static int[][] range = new int[2000][2000];

    //深度优先搜索
    public static void dfs(int x) {
        //选完了所有的数字
        if (x > n) {
            for (int j = 1; j <= n; j++) {
                range[idx][j] = ans[j];
            }
            idx++;
            return;
        }
        //把所有数字都遍历一遍
        for (int i = 1; i <= n; i++)
            //判断哪些数字还没有被选
            if (!used[i]) {
                //选择当前点
                ans[x] = i;
                used[i] = true;
                //继续往下搜索
                dfs(x + 1);
                //下方操作完毕，进行回溯操作
                used[i] = false;
            }
    }

    //检测当前的组合是否符合要求
    public static boolean judge(int text[], int n) {
        MyStack st = new MyStack();
        int pat = 1, te = 1;
        int[] pattern = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pattern[i] = i;
        }
        st.push(pattern[pat++]);
        while (te <= n) {
            //匹配正确的情况
            if (text[te] == st.getTop()) {
                te++;
                st.pop();
                //当栈无元素时就将一个数压栈中
                if (st.isEmpty() && pat <= n) st.push(pattern[pat++]);
                //匹配不正确的情况
            } else {
                //若无元素可压入则返回false
                if (pat <= n)
                    st.push(pattern[pat++]);
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        //开一个文件
        File file = new File("F:\\work\\data.txt");
        FileWriter pr = new FileWriter(file);
        Arrays.fill(used, false);
        Scanner src = new Scanner(System.in);
        n = src.nextInt();
        //从1开始搜起
        dfs(1);
        String tmp;
        for (int i = 0; i < idx; i++) {
            for (int j = 1; j <= n; j++) {
                //将这段文字转为字符串
                tmp = range[i][j] + "   ";
                //写入
                pr.write(tmp);
                pr.flush();
            }
            //将这段文字转为字符串
            tmp = ": " + judge(range[i], n) + "\n";
            //写入
            pr.write(tmp);
            pr.flush();
        }
        pr.close();
    }
}
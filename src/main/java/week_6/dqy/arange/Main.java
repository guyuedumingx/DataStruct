package week_6.dqy.arange;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 这里用了深度优先搜索来做，
 * 因为递归本质就是对栈的运用
 * 深度优先搜索使用的就是栈
 * 所以这里也算是用栈实现全排列了
 */

//栈实现全排列
public class Main {
    public static int n;
    public static int[] ans = new int[100];
    public static boolean[] used = new boolean[100];
    //深度优先搜索
    public static void dfs(int x) {
        //选完了所有的数字
        if (x > n) {
            for (int j = 1; j <= n; j++)
                System.out.print("     "+ans[j]);
            System.out.println();
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

    public static void main(String[] args) {
        Arrays.fill(used,false);
        Scanner src = new Scanner(System.in);
        n = src.nextInt();
        //从1开始搜起
        dfs(1);
    }

}


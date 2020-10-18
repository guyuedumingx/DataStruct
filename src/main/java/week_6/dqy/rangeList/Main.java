package week_6.dqy.rangeList;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int n, idx = 0;
    public static int[] ans = new int[10];
    public static boolean[] used = new boolean[10];
    public static rList[] theList = new rList[2000];

    //深度优先搜索
    public static void dfs(int x) {
        //选完了所有的数字
        if (x > n) {
            theList[idx] = new rList();
            rList.Node cur = theList[idx].head;
            for (int j = 1; j <= n; j++) {
                cur.next = new rList.Node(ans[j]);
                cur = cur.next;
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

    public static void main(String[] args) {
        Arrays.fill(used, false);
        Scanner src = new Scanner(System.in);
        n = src.nextInt();
        //从1开始搜起
        dfs(1);
        for (int i = 1; i < idx; i++) {
            theList[i].printList();
            System.out.println();
        }
    }
}
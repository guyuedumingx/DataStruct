package week_9.dqy;

import java.util.Scanner;

public class count24 {
    //用于存储4个数
    int[][] num = new int[30][5];
    int[] tmp = new int[5], inputNum = new int[5];
    int idx = 0;
    char[] operator = {'+', '-', '*', '/'};
    boolean[] used = new boolean[5];

    //用深度优先搜索找到所有的可能
    void dfs(int x) {
        //选完了所有的数字
        if (x > 4) {
            for (int j = 1; j <= 4; j++)
                num[idx][j] = tmp[j];
            idx++;
            return;
        }
        //把所有数字都遍历一遍
        for (int i = 1; i <= 4; i++)
            //判断哪些数字还没有被选
            if (!used[i]) {
                //选择当前点
                tmp[x] = inputNum[i];
                used[i] = true;
                //继续往下搜索
                dfs(x + 1);
                //下方操作完毕，进行回溯操作
                used[i] = false;
            }
    }

    //第一种建树方式计算
    public void calNum1() {
        Scanner src = new Scanner(System.in);
        for (int i = 1; i < 5; i++) {
            inputNum[i] = src.nextInt();
        }
        dfs(0);
        CntTree calTree = new CntTree();
        calTree.makeTree1(inputNum);
    }

    //第二种建树方式计算
    public void calNum2() {
        Scanner src = new Scanner(System.in);
        for (int i = 1; i < 5; i++) {
            inputNum[i] = src.nextInt();
        }
        dfs(0);
        CntTree calTree = new CntTree();
        calTree.makeTree2(inputNum);
    }
}
package week_9.dqy;

import util.dqy.QyQueue;

import java.util.Scanner;

public class LongestPath {
    public static int[][] bits = new int[500][500];
    public static int idx = 0;

    //遍历这
    public static void dfs(CodeTree.Node root) {
        if (root == null) return;
        //当访问到叶子结点时就进行转换
        if (root.left == null && root.right == null) {
            char[] tmp = root.val.toString().toCharArray();
            //第一个位置用来存下当前串的长度，方便后续继续计算
            bits[idx][0] = tmp.length;
            //把串转换为int方便后续计算
            for (int i = 0; i < tmp.length; i++) {
                bits[idx][tmp.length - i] = Integer.parseInt(String.valueOf(tmp[i]));
            }
            idx++;
            return;
        }
        //往左走则在串后面加0
        if (root.left != null) {
            root.left.val = root.val + "0";
            dfs(root.left);
        }
        //往右走则在串后加1
        if (root.right != null) {
            root.right.val = root.val + "1";
            dfs(root.right);
        }
    }

    //异或两个串以得到路径长
    public static int countLen(int[] a, int[] b) {
        int len = a[0] + b[0], i = 1;
        //相同则继续往后找
        while (i <= Math.min(a[0], b[0]) && (a[i] ^ b[i++]) == 0) len -= 2;
        return len;
    }

    public static int findLongestPath(CodeTree.Node root) {
        int mx = 0;
        //遍历路径以得到所有串
        dfs(root);
        //不同串之间异或，然后找最大值
        for (int i = 0; i < idx; i++) {
            for (int j = i + 1; j < idx; j++) {
                mx = Math.max(mx, countLen(bits[i], bits[j]));
            }
        }
        return mx;
    }

    public static void main(String[] args) {
        CodeTree newTree = new CodeTree();
        newTree.buildTree();
        int path = LongestPath.findLongestPath(newTree.root);
        System.out.println("最长路径为：" + path);
    }
}

class CodeTree {
    class Node<T> {
        T val;
        Node left;
        Node right;

        Node(T val) {
            this.val = val;
        }
    }

    //创建头结点
    Node root = new Node("0");

    //根据输入创建一棵树
    public void buildTree() {
        Scanner src = new Scanner(System.in);
        this.root.val = src.next();
        QyQueue<Node> q = new QyQueue<Node>();
        q.push(this.root);
        //当前队列不为空时
        while (!q.isEmpty()) {
            //获取结点
            Node cur = q.getFront();
            q.pop();
            //创建两个结点分别为左节点和右节点
            Node ln = new Node(src.next());
            Node rn = new Node(src.next());
            //“#”代表空
            //判断当前点是否为空，为空则连入结点中，并继续处理后续的点
            if (!ln.val.equals("#")) {
                cur.left = ln;
                q.push(ln);
            }
            if (!rn.val.equals("#")) {
                cur.right = rn;
                q.push(rn);
            }
        }
    }
}
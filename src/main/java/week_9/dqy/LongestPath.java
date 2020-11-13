package week_9.dqy;

import util.dqy.QyQueue;
import util.dqy.QyTree;

import java.util.Arrays;
import java.util.Scanner;

public class LongestPath {
    int[][] bits = new int[500][500];
    int idx = 0;
    void dfs(CodeTree.Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            char[] tmp = root.val.toString().toCharArray();
            for (int i = 0; i < tmp.length; i++) {
                bits[idx][tmp.length - i - 1] = Integer.parseInt(String.valueOf(tmp[i]));
            }
            idx++;
            return;
        }
        if (root.left != null) {
            root.left.val = root.val + "0";
            dfs(root.left);
        }
        if (root.right != null) {
            root.right.val = root.val + "1";
            dfs(root.right);
        }
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
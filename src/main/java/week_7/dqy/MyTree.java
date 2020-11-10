package week_7.dqy;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MyTree {

    static class Node {
        char val;
        Node left;
        Node right;

        Node(char val) {
            this.val = val;
        }
    }

    Node root = new Node('#');

    //层序遍历建树
    static MyTree buildTree(String str) {
        MyTree newTree = new MyTree();
        char[] tmp = str.toCharArray();
        newTree.root.val = tmp[0];
        ArrayBlockingQueue<Node> q = new ArrayBlockingQueue<Node>(200);
        q.add(newTree.root);
        int idx = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            while (len-- != 0) {
                Node cur = q.poll();
                if (idx < str.length()) {
                    Node lt = new Node(tmp[idx++]);
                    Node rt = new Node(tmp[idx++]);
                    cur.left = lt;
                    cur.right = rt;
                    if (lt.val != '#') {
                        q.add(lt);
                    }
                    if (rt.val != '#') {
                        q.add(rt);
                    }
                }
            }
        }
        return newTree;
    }

    //层序遍历二叉树
    void Search() {
        ArrayBlockingQueue<Node> q = new ArrayBlockingQueue<Node>(200);
        q.add(this.root);
        while (!q.isEmpty()) {
            int len = q.size();
            while (len-- != 0) {
                Node cur = q.poll();
                System.out.print(cur.val + " ");
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        String str = "123456789";
        MyTree newTree = MyTree.buildTree(str);
        newTree.Search();
    }
}


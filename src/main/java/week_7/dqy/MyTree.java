package week_7.dqy;

import util.dqy.QyQueue;
import util.dqy.QyTree;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MyTree {

//    static class Node {
//        char val;
//        Node left;
//        Node right;
//
//        Node(char val) {
//            this.val = val;
//        }
//    }
//
//    Node root = new Node('#');

    //层序遍历建树
//    static MyTree buildTree(String str) {
//        MyTree newTree = new MyTree();
//        char[] tmp = str.toCharArray();
//        newTree.root.val = tmp[0];
//        QyQueue<Node> q = new QyQueue<Node>();
//        q.push(newTree.root);
//        int idx = 1;
//        while (!q.isEmpty()) {
//            int len = q.size();
//            while (len-- != 0) {
//                Node cur = q.getFront();
//                q.pop();
//                if (idx < str.length()) {
//                    Node lt = new Node(tmp[idx++]);
//                    Node rt = new Node(tmp[idx++]);
//                    cur.left = lt;
//                    cur.right = rt;
//                    if (lt.val != '#') {
//                        q.push(lt);
//                    }
//                    if (rt.val != '#') {
//                        q.push(rt);
//                    }
//                }
//            }
//        }
//        return newTree;
//    }

    //层序遍历二叉树
//    void Search() {
//        QyQueue<Node> q = new QyQueue<Node>();
//        q.push(this.root);
//        while (!q.isEmpty()) {
//            int len = q.size();
//            while (len-- != 0) {
//                Node cur = q.getFront();
//                q.pop();
//                System.out.print(cur.val + " ");
//                if (cur.left != null) q.push(cur.left);
//                if (cur.right != null) q.push(cur.right);
//            }
//            System.out.println();
//        }
//    }


    public static void main(String[] args) {
//        String str = "123456789";
        QyTree<String> newTree = new QyTree<>();
        newTree.buildTree();
        newTree.Search();
//        QyQueue<Integer> q = new QyQueue<>();
//        q.push(1);
//        q.push(1);
//        q.push(1);
//        q.push(1);
//        q.push(1);
//        System.out.println(q.size());
    }
}


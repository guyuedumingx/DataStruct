package util.dqy;

import util.dqy.QyStack;

import java.util.Scanner;

public class QYZigZagTree<T> {
    class Node<T> {
        T val;
        Node left;
        Node right;

        Node(T val) {
            this.val = val;
        }
    }

    Node root = new Node("0");

    public void buildTree(int lr) {
        Scanner src = new Scanner(System.in);
        Node cur = this.root;
        cur.val = src.next();
        String num = src.next();
        int f = lr;
        while (!num.equals("#")) {
            num = src.next();
            Node tmp = new Node(num);
            if (f == 1) {
                cur.left = tmp;
                cur = tmp;
                f = 0;
            } else {
                cur.right = tmp;
                cur = tmp;
                f = 1;
            }
        }
    }

    QYZigZagTree reverse(QYZigZagTree tree) {
        QYZigZagTree newTree = new QYZigZagTree();
        int flag;
        QyStack<T> st = new QyStack<>();
        Node root = tree.root;
        if (root == null) return null;
        else {
            st.push((T) root.val);
            Node cur;
            if (root.left == null) {
                flag = 0;
                cur = root.right;
            } else {
                flag = 1;
                cur = root.left;
            }
            while (cur != null) {
                st.push((T) cur.val);
                if (flag == 1) {
                    cur = cur.right;
                    flag = 0;
                } else {
                    cur = cur.left;
                    flag = 1;
                }
            }
            newTree.root.val = st.getTop();
            st.pop();
            cur = newTree.root;
            while (!st.isEmpty()) {
                Node tmp = new Node(st.getTop());
                st.pop();
                if (flag == 0) {
                    cur.left = tmp;
                    cur = tmp;
                    flag = 1;
                } else {
                    cur.right = tmp;
                    cur = tmp;
                    flag = 0;
                }
            }
            return newTree;
        }
    }

    void searchZIgZagTree() {
        int flag = this.root.left == null ? 1 : 0;
        Node cur = this.root;
        while (cur != null) {
            System.out.print(cur.val + " ");
            if (flag == 1) {
                cur = cur.right;
                flag = 0;
            } else {
                cur = cur.left;
                flag = 1;
            }
        }
    }
}
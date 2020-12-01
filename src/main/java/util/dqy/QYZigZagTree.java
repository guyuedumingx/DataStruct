package util.dqy;

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

    //创建一个树
    public void buildTree(int lr) {
        Scanner src = new Scanner(System.in);
        Node cur = this.root;
        //给根节点赋值
        cur.val = src.next();
        //先给新节点
        String num = src.next();
        //用于标记下一个接节点该创建左还是创建右
        int f = lr;
        //遇到“#”结束
        while (!num.equals("#")) {
            //创建新节点
            Node tmp = new Node(num);
            //创建左
            if (f == 1) {
                cur.left = tmp;
                cur = tmp;
                f = 0;
            //创建右
            } else {
                cur.right = tmp;
                cur = tmp;
                f = 1;
            }
            //下一个节点的值
            num = src.next();
        }
    }

    public QYZigZagTree reverse() {
        //旧的树
        QYZigZagTree tree = this;
        //新的树
        QYZigZagTree newTree = new QYZigZagTree();
        //标记
        int flag;
        QyStack<T> st = new QyStack<>();
        //头节点
        Node root = tree.root;
        //树为空
        if (root == null) return null;
        else {
            st.push((T) root.val);
            Node cur;
            //先看看下一个点在左还是右
            if (root.left == null) {
                flag = 0;
                cur = root.right;
            } else {
                flag = 1;
                cur = root.left;
            }
            //当节点不为空时，往下搜，同时用栈存下当前值
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
            //先赋值给新树
            newTree.root.val = st.getTop();
            st.pop();
            cur = newTree.root;
            //当栈不为空时建树，因为是反转所以flag要反过来
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

    public void searchZIgZagTree() {
        int flag = this.root.left == null ? 1 : 0;
        Node cur = this.root;
        //当不为空时往下搜索
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
        System.out.println();
    }
}
package util.dqy;

import week_7.dqy.MyTree;

import java.util.Scanner;

public class QyTree<T> {
    static class Node<T> {
        T val;
        Node left;
        Node right;

        Node(T val) {
            this.val = val;
        }
    }

    Node root = new Node('#');

    MyTree buildTree() {
        Scanner src = new Scanner(System.in);
        MyTree newTree = new MyTree();
        root.val = src.next();
        QyQueue<Node> q = new QyQueue<Node>();
        q.push(root);
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
        return newTree;
    }
}

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
        while (!q.isEmpty()) {
            Node cur = q.getFront();
            q.pop();

        }
        return newTree;
    }
}

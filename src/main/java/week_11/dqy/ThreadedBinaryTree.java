package week_11.dqy;

import util.dqy.QyQueue;
import util.dqy.QyTree;

import java.util.Scanner;

public class ThreadedBinaryTree<T> {
    class Node<T> {
        T val;
        Node<T> left;
        Node<T> right;
        Node<T> fa;
        Node(T val) {
            this.val = val;
        }
    }

    Node root = new Node(null);

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

    void dfs(Node root, Node fa) {
        if(root == null) return;
        root.fa = fa;
        dfs(root.left, root);
        dfs(root.right, root);
    }

    public static void main(String[] args) {
        ThreadedBinaryTree newTree = new ThreadedBinaryTree();
        newTree.buildTree();
        newTree.dfs(newTree.root, null);

    }
}

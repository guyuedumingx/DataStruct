package util.dqy;

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

    //创建头结点
    Node root = new Node("#");

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

    //遍历并输出一棵树
    public void Search() {
        QyQueue<Node> q = new QyQueue<Node>();
        q.push(this.root);
        while (!q.isEmpty()) {
            int len = q.size();
            while (len-- != 0) {
                Node cur = q.getFront();
                q.pop();
                System.out.print(cur.val + " ");
                if (cur.left != null) q.push(cur.left);
                if (cur.right != null) q.push(cur.right);
            }
            System.out.println();
        }
    }

}

package util.dqy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QyTree<T> {
    class Node<T> {
        T val;
        Node left;
        Node right;

        Node(T val) {
            this.val = val;
        }
    }

    //创建头结点
    public Node root = new Node("#");
    //叶节点个数
    public int AmountOfLeaves = 0;
    //分支节点个数
    public int AmountOfBranch = 0;

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

    //创建一个数组来存二叉树
    public T[] createTreeArray() {
        QyQueue<Node> q = new QyQueue<Node>();
        //创建一个数组来存二叉树
        T[] arr = (T[]) new String[500];
        //所有结点处使化为空（"#"代表空）
        Arrays.fill(arr, "#");
        //记录当前下标
        HashMap<Node, Integer> idxOfNode = new HashMap<Node, Integer>();
        q.push(this.root);
        arr[1] = (T) this.root.val;
        idxOfNode.put(this.root, 1);
        while (!q.isEmpty()) {
            Node cur = q.getFront();
            q.pop();
            //有左节点就存下左节点
            if (cur.left != null) {
                q.push(cur.left);
                arr[idxOfNode.get(cur) * 2] = (T) cur.left.val;
                idxOfNode.put(cur.left, idxOfNode.get(cur) * 2);
            }
            //有右节点就存下右节点
            if (cur.right != null) {
                q.push(cur.right);
                arr[idxOfNode.get(cur) * 2 + 1] = (T) cur.right.val;
                idxOfNode.put(cur.right, idxOfNode.get(cur) * 2 + 1);
            }
        }
        return (T[]) arr;
    }

    //遍历并输出一棵树
    public void Search() {
        QyQueue<Node> q = new QyQueue<Node>();
        q.push(this.root);
        //层序遍历
        while (!q.isEmpty()) {
            //获取长度，主要是为了分层输出
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

    //递归先序遍历
    public void Dlr(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        Dlr(root.left);
        Dlr(root.right);
    }

    //递归中序遍历
    public void Ldr(Node root) {
        if (root == null) return;
        Ldr(root.left);
        System.out.print(root.val + " ");
        Ldr(root.right);
    }

    //递归后续遍历
    public void Led(Node root) {
        if (root == null) return;
        Led(root.left);
        Led(root.right);
        System.out.print(root.val + " ");
    }

    //用栈实现前序遍历
    public void DlrByStack() {
        QyStack<Node> stk = new QyStack<Node>();
        Node root = this.root;
        while (root != null || !stk.isEmpty()) {
            //先一直往左走，走到底
            while (root != null) {
                //在左走时遇到什么结点就输出什么节点
                System.out.print(root.val + " ");
                stk.push(root);
                root = root.left;
            }
            //回溯
            root = stk.getTop();
            stk.pop();
            //访问右节点
            root = root.right;
        }
    }

    //用栈实现中序遍历
    public void LdrByStack() {
        QyStack<Node> stk = new QyStack<Node>();
        Node root = this.root;
        while (root != null || !stk.isEmpty()) {
            //先一直往左走，走到底
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            //回溯
            root = stk.getTop();
            stk.pop();
            //回溯的时候访问当前结点
            System.out.print(root.val + " ");
            //访问右节点
            root = root.right;
        }
    }

    //*用栈实现后序遍历
    public void LrdByStack() {
        QyStack<Node> stk = new QyStack<Node>();
        Node root = this.root;
        Map<Node, Boolean> used = null;
        while (root != null || !stk.isEmpty()) {
            //先一直往左走，走到底
            while (root != null) {
                stk.push(root);
                used.put(root, true);
                root = root.left;
            }
            System.out.println(root);
            //回溯
            root = stk.getTop();
            stk.pop();
            //访问右节点
            root = root.right;
            stk.push(root);
        }
    }

    //统计二叉树的叶子结点
    public void countLeaves(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            AmountOfLeaves++;
            return;
        }
        countLeaves(root.left);
        countLeaves(root.right);
    }

    //统计二叉树的分支结点
    public void countBranch(Node root) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            AmountOfLeaves++;
        }
        countBranch(root.left);
        countBranch(root.right);
    }

    //计算数的深度(根结点的深度为0)
    public int countDepth() {
        QyQueue<Node> q = new QyQueue<Node>();
        int depth = 0;
        q.push(this.root);
        while (!q.isEmpty()) {
            int len = q.size();
            depth++;
            for (int i = 0; i < len; i++) {
                Node cur = q.getFront();
                q.pop();
                if (cur.left != null) q.push(cur.left);
                if (cur.right != null) q.push(cur.right);
            }
        }
        return depth;
    }
}

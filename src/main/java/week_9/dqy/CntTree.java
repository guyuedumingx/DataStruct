package week_9.dqy;

public class CntTree<T> {
    public class Node<T> {
        T val;
        Node left;
        Node right;

        Node(T val) {
            this.val = val;
        }
    }

    Node root = new Node(0);

    //构造树
    //形态一
    public void makeTree1(int[] cNum) {
        CntTree.Node cur = this.root;
        cur.left = new Node(0);
        cur.right = new Node(cNum[4]);
        cur = cur.left;
        cur.left = new Node(0);
        cur.right = new Node(cNum[3]);
        cur = cur.left;
        cur.left = new Node(cNum[1]);
        cur.right = new Node(cNum[2]);
    }

    //形态二
    public void makeTree2(int[] cNum) {
        CntTree.Node cur = this.root;
        CntTree.Node LTmp = new Node(0);
        CntTree.Node RTmp = new Node(0);
        LTmp.left = new Node(cNum[1]);
        LTmp.right = new Node(cNum[2]);
        RTmp.left = new Node(cNum[3]);
        RTmp.right = new Node(cNum[4]);
    }

    //遍历计算
//    dfs() {
//
//    }
}

package week_10.dqy;


import util.dqy.QyTree;

public class ReverseBinaryTree {
    public static QyTree.Node reverseTree(QyTree.Node root) {
        if (root == null) return null;
        QyTree.Node tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        reverseTree(root.left);
        reverseTree(root.right);
        return root;
    }
    public static QyTree reverse(QyTree tmpTree) {
        tmpTree.root = reverseTree(tmpTree.root);
        return tmpTree;
    }

    public static void main(String[] args) {
        QyTree newTree = new QyTree();
        newTree.buildTree();
        newTree = reverse(newTree);
        newTree.Search();
    }
}

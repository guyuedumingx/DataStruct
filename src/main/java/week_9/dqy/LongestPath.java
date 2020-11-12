package week_9.dqy;

import util.dqy.QyTree;

public class LongestPath {
    StringBuilder[] path = new StringBuilder[200];
    StringBuilder str = new StringBuilder();
    int idx = 0;
    void dfs(QyTree.Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {

        }
        if (root.left != null) {
            str.append(root.val);
            dfs(root.left);
            str.deleteCharAt(str.length() - 1);
        }
        if (root.right != null) {
            dfs(root.left);
        }
    }

//    int findLongestPath() {
//        QyTree newTree = new QyTree();
//        newTree.buildTree();
//
//    }
}

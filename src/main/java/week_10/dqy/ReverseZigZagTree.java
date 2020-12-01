package week_10.dqy;

import util.dqy.QYZigZagTree;
import util.dqy.QyTree;

public class ReverseZigZagTree {
    public static void main(String[] args) {
        QYZigZagTree tree = new QYZigZagTree();
        tree.buildTree(1);
        tree.searchZIgZagTree();
        QYZigZagTree ans = tree.reverse();
        ans.searchZIgZagTree();
    }
}
package week_9.dqy;

import util.dqy.QyTree;

public class TestWeek9Tree {
    public static void main(String[] args) {
        QyTree newTree = new QyTree();
        newTree.buildTree();
        newTree.countLeaves(newTree.root);
        newTree.countBranch(newTree.root);
        System.out.println("树的叶子节点数是：" + newTree.AmountOfLeaves);
        System.out.println("树的分支节点数是：" + newTree.AmountOfBranch);
        System.out.println("树的高度是：" + newTree.countDepth());
    }
}

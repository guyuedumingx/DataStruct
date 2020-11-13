package week_9.dqy;

import util.dqy.QyTree;

public class TestWeek9Tree {
    public static void main(String[] args) {
        QyTree newTree = new QyTree();
        //建树
        newTree.buildTree();
        //统计叶子结点个数
        newTree.countLeaves(newTree.root);
        //统计分支节点个数
        newTree.countBranch(newTree.root);
        //输出
        System.out.println("树的叶子节点数是：" + newTree.AmountOfLeaves);
        System.out.println("树的分支节点数是：" + newTree.AmountOfBranch);
        //输出树的高度（根结点的高度为1）
        System.out.println("树的高度是：" + newTree.countDepth());
    }
}

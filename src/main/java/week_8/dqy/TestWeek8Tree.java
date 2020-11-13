package week_8.dqy;

import util.dqy.QyTree;

public class TestWeek8Tree {
    public static void main(String[] args) {
        QyTree newTree = new QyTree();
        newTree.buildTree();
        System.out.println("递归前序遍历");
        newTree.Dlr(newTree.root);
        System.out.println();
        System.out.println("递归中序遍历");
        newTree.Ldr(newTree.root);
        System.out.println();
        System.out.println("递归后序遍历");
        newTree.Lrd(newTree.root);
        System.out.println();
        System.out.println("非递归前序遍历");
        newTree.DlrByStack();
        System.out.println();
        System.out.println("非递归中序遍历");
        newTree.LdrByStack();
        System.out.println();
        //写出一个树的前中后序的遍历结果
        int[] preOrder = {1, 2, 4, 5, 3, 6};
        int[] inOrder = {4, 2, 5, 1, 6, 3};
        int[] postOrder = {4, 5, 2, 6, 3, 1};
        QyTree op = new QyTree();
        //前序中序建树
        QyTree.Node PITree = op.PIBuildTree(preOrder, inOrder);
        //中序后序建树
        QyTree.Node IPTree = op.IPBuildTree(inOrder, postOrder);
    }
}

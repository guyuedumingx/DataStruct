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

    }
}

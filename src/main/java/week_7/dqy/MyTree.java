package week_7.dqy;

import util.dqy.QyTree;

public class MyTree {
    public static void main(String[] args) {
        QyTree<String> newTree = new QyTree<>();
        newTree.buildTree();
        newTree.Search();
        String[] arr = newTree.createTreeArray();
        System.out.println();
    }
}


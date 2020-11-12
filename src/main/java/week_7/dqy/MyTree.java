package week_7.dqy;

import util.dqy.QyTree;

public class MyTree {
    public static void main(String[] args) {
        QyTree<String> newTree = new QyTree<>();
        newTree.buildTree();
        newTree.Search();
        System.out.println();
        newTree.Dlr(newTree.root);
        System.out.println();
        newTree.DlrByStack();
//        QyQueue<Integer> q = new QyQueue<>();
//        q.push(1);
//        q.push(1);
//        q.push(1);
//        q.push(1);
//        q.push(1);
//        System.out.println(q.size());
    }
}


package util.dqy;

import java.util.Arrays;

public class QYHuffmanTree<T> {
    class Node<T> {
        T val;
        Node left;
        Node right;

        Node(T val) {
            this.val = val;
        }
    }
//
//    public QYHuffmanTree createQYHuffmanTree(T[] num) {
//        QYHuffmanTree newTree = new QYHuffmanTree();
//        Arrays.sort(num);
//        for (int i = 1; i < num.length; i++) {
//            Node tmp1 = new Node(num[i - 1]);
//            Node tmp2 = new Node(num[i]);
//            Node f =
//        }
//    }
}
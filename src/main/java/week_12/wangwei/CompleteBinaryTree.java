package week_12.wangwei;

import util.wangwei.TreeNode;
import week_8.wangwei.BuildTree;

/**
 * 补全二叉树
 * @author yohoyes
 */
public class CompleteBinaryTree {
    public static void main(String[] args) {
        String str = "#123#56#";
        char[] chars = str.toCharArray();
        TreeNode<Character> root = new TreeNode(chars[1]);
        BuildTree.buildTree(root,chars,1);
        complete(root);
    }

    private static void complete(TreeNode<Character> node){
        if(node==null||(node.getLeft()==null&&node.getRight()==null)) {
            return;
        }
        if(node.getLeft()==null){
            int i = node.getRight().getValue() - 1;
            TreeNode left = new TreeNode((char)i);
            node.setLeft(left);
        }
        if(node.getRight()==null){
            int i = node.getLeft().getValue() + 1;
            TreeNode right = new TreeNode((char)i);
            node.setRight(right);
        }
        complete(node.getLeft());
        complete(node.getRight());
    }
}

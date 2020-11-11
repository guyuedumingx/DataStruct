package week_10.wangwei;

import util.wangwei.TreeNode;
import week_8.wangwei.BuildTree;

/**
 * 反转二叉树
 * @author yohoyes
 */
public class ReverseBinaryTree {

    public static void main(String[] args) {
        String str = "#1234567";
        char[] chars = str.toCharArray();
        TreeNode<Character> root = new TreeNode<Character>(chars[1]);
        BuildTree.buildTree(root,chars,1);
        reverse(root);
    }

    /**
     * 翻转二叉树
     * @param root
     */
    public static void reverse(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode left = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(left);
        reverse(root.getLeft());
        reverse(root.getRight());
    }

}

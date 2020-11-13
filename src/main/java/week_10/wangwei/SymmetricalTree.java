package week_10.wangwei;

import util.wangwei.TreeNode;
import week_8.wangwei.BuildTree;

/**
 * 把不对称的二叉树通过添加节点转化成对称的二叉树
 * @author yohoyes
 */
public class SymmetricalTree {

    public static void main(String[] args) {
        String str = "#123#5#6##78";
        char[] chars = str.toCharArray();
        TreeNode<Character> root = new TreeNode<Character>(chars[1]);
        BuildTree.buildTree(root,chars,1);
        symmmetric(root.getLeft(),root.getRight());
    }

    public static void symmmetric(TreeNode left, TreeNode right){
        //是两个都是叶子节点,直接返回
        if(left.getLeft()==null&&right.getRight()==null){
            return;
            //对比两边
        }else if(left.getLeft()==null){
            //补全左边
            TreeNode treeNode = new TreeNode(right.getRight().getValue());
            left.setLeft(treeNode);
        }else if(right.getRight()==null){
            //补全右边
            TreeNode treeNode = new TreeNode(left.getLeft().getValue());
            right.setRight(treeNode);
        }

        //对比中间
        if(left.getRight()==null&&right.getLeft()==null){
            return;
        }else if(left.getRight()==null){
            //补全左边
            TreeNode treeNode = new TreeNode(right.getLeft().getValue());
            left.setRight(treeNode);
        }else if(right.getLeft()==null){
            //补全右边
            TreeNode treeNode = new TreeNode(left.getRight().getValue());
            right.setLeft(treeNode);
        }

        //对比子节点
        symmmetric(left.getLeft(),right.getRight());
        symmmetric(left.getRight(),right.getLeft());
    }
}

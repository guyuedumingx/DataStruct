package week_10.wangwei;

import util.wangwei.TreeNode;
import week_8.wangwei.BuildTree;


/**
 * 反转单支ZigZag树
 */
public class ReverseZigZagTree {

    public static void main(String[] args) {
        String str = "#123";
        char[] chars = str.toCharArray();
        TreeNode<Character> root = new TreeNode<Character>(chars[1]);
        BuildTree.buildZigZagTree(root,chars,2,false);
        root = reverseZigZag(root);

    }

    /**
     * 反转单支ZigZag树
     * 同样是反转子树
     * 区别是要返回最深的那个叶子节点
     * 要考虑到怎么只返回最深的子节点,因为整颗树都翻过来了,所以最里面的节点变成了根节点
     * @param root 根节点
     * @return
     */
    public static TreeNode reverseZigZag(TreeNode root){
        if(root==null){return null;}
        TreeNode node = null;
        //如果左子节点不是空,因为是ZigZag树,那么右边的节点就是空的
        if(root.getLeft()!=null){
            TreeNode left = root.getLeft();
            node = reverseZigZag(left);
            if(node!=null){
                left.setRight(root);
                root.setLeft(null);
            }
            return node;
        }else if(root.getRight()!=null){
            TreeNode right = root.getRight();
            node = reverseZigZag(right);
            if(node!=null){
                right.setLeft(root);
                root.setRight(null);
            }
            return node;
        }else {
            return root;
        }
    }
}

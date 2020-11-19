package week_8.wangwei;

import util.wangwei.MyQueue;
import util.wangwei.TreeNode;

/**
 * 层次建立一棵树
 * @author yohoyes
 */
public class BuildTree {
    public static void main(String[] args) {
        TreeNode build = build(10);
    }

    /**
     * 层序建立二叉树
     * @param length
     * @return
     */
    public static TreeNode build(int length){
        if(length<1){
            return null;
        }
        MyQueue<TreeNode> queue = new MyQueue<TreeNode>();
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        queue.offer(root);
        for(int i=2; i<=length; i++){
            TreeNode poll = queue.peek();
            TreeNode<Integer> node = new TreeNode<Integer>(i);
            if(poll.getLeft()==null){
                poll.setLeft(node);
                queue.offer(node);
            }else if(poll.getRight()==null){
                poll.setRight(node);
                queue.offer(node);
            }else {
                queue.poll();
            }
        }
        return root;
    }

    /**
     * arr[0]空着
     * 根目录在arr[1]
     * @param arr
     */
    public static void buildTree(TreeNode root,char[] arr, int i){
        if(i>arr.length/2){return;}
        if(2*i<arr.length){
            if(arr[i*2]!='#') {
                TreeNode<Character> left = new TreeNode<Character>(arr[i * 2]);
                root.setLeft(left);
                buildTree(left, arr, i * 2);
            }
        }
        if(2*i+1<arr.length){
            if(arr[i*2+1]!='#') {
                TreeNode<Character> right = new TreeNode<Character>(arr[i * 2 + 1]);
                root.setRight(right);
                buildTree(right, arr, i * 2 + 1);
            }
        }
    }

    /**
     *
     * @param root 根
     * @param arr 构建数组
     * @param i 第一个子节点下标
     * @param isLeft 是左节点
     */
    public static void buildZigZagTree(TreeNode root, char[] arr, int i, boolean isLeft){
        if(i>=arr.length){return;}
        TreeNode<Character> node = new TreeNode<Character>(arr[i]);
        if(isLeft){
            root.setLeft(node);
            buildZigZagTree(node, arr, ++i,false);
        }else{
            root.setRight(node);
            buildZigZagTree(node, arr, ++i,true);
        }
    }
}

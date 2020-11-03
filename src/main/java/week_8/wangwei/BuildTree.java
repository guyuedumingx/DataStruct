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

    public static TreeNode build(int length){
        if(length<1){
            return null;
        }
        MyQueue<TreeNode> queue = new MyQueue<TreeNode>();
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        queue.offer(root);
        for(int i=2; i<length; i++){
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
}

package week_8.wangwei;

import util.wangwei.MyQueue;
import util.wangwei.TreeNode;


/**
 * 遍历二叉树
 * @author yohoyes
 */
public class SearchTree {

    public void bfs(TreeNode root){
        MyQueue<TreeNode> queue = new MyQueue<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.getLeft()!=null){
                System.out.println(poll.getLeft().getValue());
                queue.offer(poll.getLeft());
            }else if(poll.getRight()!=null){
                System.out.println(poll.getRight().getValue());
                queue.offer(poll.getRight());
            }
        }
    }
}

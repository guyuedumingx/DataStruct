package week_8.wangwei;

import util.wangwei.MyQueue;
import util.wangwei.TreeNode;


/**
 * 遍历二叉树
 * @author yohoyes
 */
public class SearchTree {

    /**
     * 层序遍历
     * @param root
     */
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

    /**
     * 先序遍历
     * @param node
     */
    public void preSearch(TreeNode node){
        if (node==null){
            return;
        }
        System.out.println(node.getValue());
        preSearch(node.getLeft());
        preSearch(node.getRight());
    }

    /**
     * 中序遍历
     * @param node
     */
    public void midSearch(TreeNode node){
        if(node==null){return;}
        midSearch(node.getLeft());
        System.out.println(node.getValue());
        midSearch(node.getRight());
    }

    /**
     * 后序遍历
     * @param node
     */
    public void sufSearch(TreeNode node){
        if(node==null){return;}
        sufSearch(node.getLeft());
        sufSearch(node.getRight());
        System.out.println(node.getValue());
    }

    public void midSearchNoRecursion(TreeNode root){
         
    }
}

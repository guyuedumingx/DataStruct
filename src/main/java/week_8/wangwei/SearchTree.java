package week_8.wangwei;

import util.wangwei.MyQueue;
import util.wangwei.MyStack;
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
    public static void bfs(TreeNode root){
        MyQueue<TreeNode> queue = new MyQueue<TreeNode>();
        queue.offer(root);
        System.out.print(root.getValue()+"\t");
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.getLeft()!=null){
                System.out.print(poll.getLeft().getValue()+"\t");
                queue.offer(poll.getLeft());
            }
            if(poll.getRight()!=null){
                System.out.print(poll.getRight().getValue()+"\t");
                queue.offer(poll.getRight());
            }
        }
        System.out.println();
    }

    /**
     * 先序遍历
     * @param node
     */
    public static void preSearch(TreeNode node){
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
    public static void midSearch(TreeNode node){
        if(node==null){return;}
        midSearch(node.getLeft());
        System.out.println(node.getValue());
        midSearch(node.getRight());
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void sufSearch(TreeNode node){
        if(node==null){return;}
        sufSearch(node.getLeft());
        sufSearch(node.getRight());
        System.out.println(node.getValue());
    }

    public void midSearchNoRecursion(TreeNode root){
        if(root==null){return;}
        MyStack<TreeNode> stack = new MyStack<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty()){
            if(node.getLeft()!=null){
                stack.push(node.getLeft());
            }
            System.out.println(node.getValue());
            if(node.getRight()!=null){
                stack.push(node.getRight());
            }
            node = stack.pop();
        }

    }
    public void sufSearchNoRecursion(TreeNode root){
        if(root==null){return;}
        MyStack<TreeNode> stack = new MyStack<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty()){
            if(node.getLeft()!=null){
                stack.push(node.getLeft());
            }
            if(node.getRight()!=null){
                stack.push(node.getRight());
            }
            System.out.println(node.getValue());
            node = stack.pop();
        }

    }
}

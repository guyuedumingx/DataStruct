package week_9.wangwei;

import util.wuyanzhen.TreeNode;
import week_8.wangwei.BuildTree;
import week_8.wangwei.SearchTree;

/**
 * 统计分支节点数
 * @author yohoyes
 */
public class CountBranch {

    public static void main(String[] args) {
        util.wangwei.TreeNode root = BuildTree.build(7);
        SearchTree.preSearch(root);
    }

    private static int count(TreeNode node){
        if(node==null){
            return 0;
        }
        if(node.getLeft()==null&&node.getRight()==null){
            return 0;
        }else {
            return count(node.getRight())+count(node.getLeft())+1;
        }
    }
}

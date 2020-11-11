package week_9.wangwei;

import util.wangwei.TreeNode;
import week_8.wangwei.BuildTree;
import week_8.wangwei.SearchTree;

/**
 * 统计叶节点个数
 * @author yohoyes
 */
public class CountLeef {

    public static void main(String[] args) {
        TreeNode root = BuildTree.build(7);
        SearchTree searchTree = new SearchTree();
        searchTree.preSearch(root);
    }

    private static int count(TreeNode node){
        if(node==null){
            return 0;
        }else if(node.getRight()==null&&node.getLeft()==null){
            return 1;
        }else {
            return count(node.getRight())+count(node.getLeft());
        }
    }
}

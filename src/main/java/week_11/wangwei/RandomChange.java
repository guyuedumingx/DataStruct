package week_11.wangwei;

import util.wangwei.TreeNode;
import week_8.wangwei.BuildTree;
import week_8.wangwei.SearchTree;

/**
 * 让命运决定谁是爸爸
 * 产生一个0-2的随机数
 * 0： 停止
 * 1： 该节点的值跟左子节点交换
 * 2： 该节点的值跟右子节点交换
 * 直到0或叶子节点
 * 这是一棵完全二叉树
 * @author yohoyes
 */
public class RandomChange {

    public static void main(String[] args) {
        TreeNode<Integer> root = BuildTree.build(15);
        //打印出来看看
        SearchTree.bfs(root);

        randomChange(root);

        //打印出来看看
        SearchTree.bfs(root);
    }

    /**
     * 产生0-2的随机数
     * @return
     */
    private static int createRandom(){
        return  (int) (Math.random() * 3);
    }

    private static void randomChange(TreeNode<Integer> root){
        int random = createRandom();
        if(random==0||(root.getLeft()==null&&root.getRight()==null)){
            return;
        }else if(random==1){
            int tmp = root.getLeft().getValue();
            root.getLeft().setValue(root.getValue());
            root.setValue(tmp);
            randomChange(root.getLeft());
        }else if(random==2){
            int tmp = root.getRight().getValue();
            root.getRight().setValue(root.getValue());
            root.setValue(tmp);
            randomChange(root.getRight());
        }
    }
}

package week_10.wangwei;


import java.util.ArrayList;

/**
 * 不懂写,停在这了
 * 有心情再说
 * @author yohoyes
 */
public class ToBinaryTree {

    private static void transferToBinaryTree(TreeNode root){
        
    }

    /**
     * 把课本P180页5.29a的树建立出来
     * @return
     */
    private static TreeNode<Character> build(){
        TreeNode<Character> root = new TreeNode<>('A');
        TreeNode<Character> bNode = new TreeNode<>('B');
        TreeNode<Character> cNode = new TreeNode<>('C');
        TreeNode<Character> dNode = new TreeNode<>('D');
        TreeNode<Character> eNode = new TreeNode<>('E');
        TreeNode<Character> fNode = new TreeNode<>('F');
        TreeNode<Character> gNode = new TreeNode<>('G');
        TreeNode<Character> hNode = new TreeNode<>('H');

        root.getChild().add(bNode);
        root.getChild().add(cNode);
        root.getChild().add(dNode);
        bNode.getChild().add(eNode);
        bNode.getChild().add(fNode);
        fNode.getChild().add(hNode);
        dNode.getChild().add(gNode);
        return root;
    }
}

class TreeNode<T> {
    private T data;
    private ArrayList<TreeNode<T>> child = new ArrayList<>();

    public TreeNode(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ArrayList<TreeNode<T>> getChild() {
        return child;
    }

    public void setChild(ArrayList<TreeNode<T>> child) {
        this.child = child;
    }
}

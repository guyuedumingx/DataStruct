package week_10.wangwei;


import java.util.ArrayList;

public class ToBinaryTree {

    private static void transferToBinaryTree(TreeNode root){
        
    }

    /**
     * 把课本P180页5.29a的树建立出来
     * @return
     */
    private static TreeNode<Character> build(){
        TreeNode<Character> root = new TreeNode<Character>('A');
        TreeNode<Character> Bnode = new TreeNode<Character>('B');
        TreeNode<Character> Cnode = new TreeNode<Character>('C');
        TreeNode<Character> Dnode = new TreeNode<Character>('D');
        TreeNode<Character> Enode = new TreeNode<Character>('E');
        TreeNode<Character> Fnode = new TreeNode<Character>('F');
        TreeNode<Character> Gnode = new TreeNode<Character>('G');
        TreeNode<Character> Hnode = new TreeNode<Character>('H');

        root.getChild().add(Bnode);
        root.getChild().add(Cnode);
        root.getChild().add(Dnode);
        Bnode.getChild().add(Enode);
        Bnode.getChild().add(Fnode);
        Fnode.getChild().add(Hnode);
        Dnode.getChild().add(Gnode);
        return root;
    }
}

class TreeNode<T> {
    private T data;
    private ArrayList<TreeNode<T>> child = new ArrayList<TreeNode<T>>();

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

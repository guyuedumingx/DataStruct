package util.wangwei;

/**
 * 树节点
 * @param <T>
 * @author yohoyes
 */
public class TreeNode<T> {
   TreeNode<T> left;
   TreeNode<T> right;
   T value;
   public TreeNode(){}
   public TreeNode(T value){
      this.value = value;
   }

   public TreeNode<T> getLeft() {
      return left;
   }

   public void setLeft(TreeNode<T> left) {
      this.left = left;
   }

   public TreeNode<T> getRight() {
      return right;
   }

   public void setRight(TreeNode<T> right) {
      this.right = right;
   }

   public T getValue() {
      return value;
   }

   public void setValue(T value) {
      this.value = value;
   }
}

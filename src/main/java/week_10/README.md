### 第十周作业  

#### 反转二叉树  

左右反转二叉树  

[**解法**](./wangwei/ReverseBinaryTree.java)    
> 每次都翻转传入的节点的子节点  

依次翻转子树  
![翻转二叉树](../../../../res/image/BubbleSort.gif)  

*代码实现*  
```java
public static void reverse(TreeNode root){
    if(root==null){
        return;
    }
    TreeNode left = root.getLeft();
    root.setLeft(root.getRight());
    root.setRight(left);
    reverse(root.getLeft());
    reverse(root.getRight());
}
```

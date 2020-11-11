### 第十周作业  

#### 反转二叉树  

左右反转二叉树  

[**解法**](./wangwei/ReverseBinaryTree.java)    
> 每次都翻转传入的节点的子节点  

依次翻转子树  
![翻转二叉树](../../../../res/image/reverseTree.gif)  

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

#### 反转单支ZigZag树  

[**解法**](./wangwei/ReverseZigZagTree.java)   

1. 如果节点有左子树  
2. 则将左子节点设置成自身的父节点  
3. 且自身是父节点的右子节点  
4. 同理设置右子树  
5. 返回最底层的节点当作根节点  

#### 将所有的叶子节点连接成一个链表  

[**解法**](./wangwei/LinkedForLeef.java)     

> 树的叶子节点从左到右依次相连  


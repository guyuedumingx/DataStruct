### 第九周作业  

**递归**  
1. 归纳基石  
2. 归纳步

> 递归的原理是`数学归纳法`  

```java
    void find(Node node){
        if(node==null)  //归纳基石
            return ;
        return find(node.left)+find(node.right); //归纳步
    }
```

#### 统计二叉树叶节点数  

#### 统计二叉树分支节点数  


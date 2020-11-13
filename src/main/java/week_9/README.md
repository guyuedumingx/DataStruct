### 第九周作业  

> 作业可以直接点进文件夹看的  
> 有时候我懒,没加链接  

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

#### 彦臻代码集合  

[**解法**](./wuyanzhen/Week9.java)  

#### 启裕代码入口  

[**解法**](./dqy/TestWeek9Tree.java)  

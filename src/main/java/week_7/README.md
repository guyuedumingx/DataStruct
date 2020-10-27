### 第七周作业  

#### 还原字母顺序  

根据一串字母如(BDCAE),将其还原成(ABCDE)形式  

[**解法**](./wangwei/Restore.java)    
> 使用两个栈,一个存放主要字母StackA,一个暂时用来调换顺序StackB   

1. 依次读取字母,首先将第一个字母(B)存入栈StackA  
2. 读取第二个字母(D),因为D比B大,将字母B存入StackB  
3. 将D存入StackA,将B存回StackA     
4. 读取C,C比B大,将B存入Stack  
5. C比D小,将C存入StackA,将B存回StackA  
6. 重复过程4-5  

> 此解法非韩冬解法  

*代码实现*  
```java
public static String restore(String str){
    char[] chars = str.toCharArray();
    for(char ch : chars){
        while (stackA.peek()!=null&&stackA.peek()<ch){
            stackB.push(stackA.pop());
        }
        stackA.push(ch);
        while (!stackB.isEmpty()){
            stackA.push(stackB.pop());
        }
    }
    StringBuilder sb = new StringBuilder();
    while (!stackA.isEmpty()){
        sb.append(stackA.pop());
    }
    return sb.toString();
}
```

#### 模拟收银台  

模拟收银台的操作,相当于有人来排队买东西,同时排队的最多有20人  
单位时间内可能来的人服从(lambda=3)的泊松分布  
每个人在收银台付钱的时间服从(theta=2)的指数分布  
一直重复下去,直到队伍满20人或者队伍空  

[**解法**](./wangwei/CashierDesk.java)    

#### 分割单词  

读取一段c语言的代码文件,将文件中的`保留字`,`操作符`,和`变量名`识别出来  
> 相当与你要一次读取字符,然后识别它是`保留字`还是`操作符`,还是`变量名`  

**解法**  

-------  

[**第七周集合**](./wuyanzhen/Week7.java)  

### 第一周作业  

[**冒泡排序**](./wangwei/BubbleSort.java)  
Code from wangwei  
![冒泡排序动图](../../../../res/image/BubbleSort.gif)  

*代码实现*  
```java
for(int i=0; i<=arr.length-1; i++) {
    for(int n=0; n<arr.length-i-1;n++) {
        if(arr[n] > arr[n+1]) {
             int temp = arr[n+1];
             arr[n+1] = arr[n];
             arr[n] = temp;
        }
    }
}
```  

*快速排序*  

![快速排序动图](../../../../res/image/QuickSort.gif)  

[**百钱百鸡**](./wangwei/ChickAndHen.java)  
Code from wangwei  

![百钱百鸡函数拟合](../../../../res/image/HensAndCock.png)  

*代码实现*  

```java  
int cock_pride = 5; 
int hen_pride = 3;
float chick_pride = 1/3;

//最大可能的公鸡数
int cock_number_top = sum/cock_pride;
//最大可能的母鸡数
int hen_number_top = sum/ hen_pride;
//公鸡数从0开始递增
for(int cock_number=0;cock_number<=cock_number_top;cock_number++) {
    //母鸡数从0开始递增
    for(int hem_number=0;hem_number<=hen_number_top;hem_number++) {
        //小鸡数
        int chick_number = sum - cock_number - hem_number;
        //小鸡数量必须是3的倍数,各种鸡的数量和价格乘积为钱数
        if(chick_number%3==0 && ((cock_number*cock_pride+hem_number* hen_pride +
                chick_number*chick_pride)==sum)){}
    }
}
``````

[**斐波那契数列**](./wangwei/Fabonacci.java)  
Code from wangwei  

*代码实现*    

```java
int fabonacci(int n) {
	if(n == 1)
        return 0;
    else if(n == 2)
        return 1;
    else
        return fabonacci(n-1) + fabonacci(n-2);
}
```

[**递归**](./wangwei/Factorial.java)  
Code from wangwei  

*代码实现*  
```java  
int factorial(int n) {
    if(n == 1)
        return 1;
    else
        return n * factorial(n-1);
}
```

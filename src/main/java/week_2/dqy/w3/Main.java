//普通人洗牌
package week_2.dqy.w3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner src=new Scanner(System.in);
        //创建数组用于存牌
        int[] arr=new int[53];
        for (int i=0;i<52;i++) {
            arr[i] = i+1;
        }
        //创建数组放置处理好的牌
        int[] newArr=new int[53];
        //这是一个随机偏移量
        int fen=(int)(-8+Math.random()*17);
        System.out.println(fen);
        //左手牌的最右边界
        int lenLeft=26+fen;
        //右手牌的最右边界
        int lenRight=52;
        //初始化左右手下牌的起点
        int i=0,j=26+fen;
        //flag用于标记当前用手
        int flag=1,x=0;
        //当左右手牌都没下完时
        while (i<lenLeft&&j<lenRight)
        {
            if (flag==1)
            {
                flag=0;
                int down=(int)(0+Math.random()*4);
                for (int t=0;t<down&&i<lenLeft;i++,t++)
                {
                    newArr[x++]=arr[i];
                }
            }
            else{
                flag=1;
                int down=(int)(0+Math.random()*4);
                for (int t=0;t<down&&j<lenRight;j++,t++)
                {
                    newArr[x++]=arr[j];
                }
            }
        }
        //把剩余的牌洗进去
        if (i==lenLeft) {
            for (; j < lenRight; j++) {
                newArr[x++] = arr[j];
            }
        }
            else {
            for (;i < lenLeft; j++) {
                newArr[x++] = arr[j];
            }
        }
        for (int p=0;p <52; p++) {
            System.out.print(newArr[p]+" ");
        }
    }
}
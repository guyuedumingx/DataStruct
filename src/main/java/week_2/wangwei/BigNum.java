package week_2;

import java.util.Scanner;

/**
 * @author zhenghuanxin
 */
public class BigNum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //定义并输入两个字符串
        Scanner sc=new Scanner(System.in);
        System.out.print("Please input the first num: ");
        String str1=sc.next();
        System.out.print("Please input the second num: ");
        String str2=sc.next();
        //传入字符串的长度，当作数组的长度
        /*
         * 两个数的位数之和大于两个数相乘之后的数的位数
         */
        int[] num1=new int[str1.length()];
        int[] num2=new int[str2.length()];
        int[] result=new int[str1.length()+str2.length()];
        //把字符串分割(substring)成个位数，并转化为整形
        for(int i=0;i<str1.length();i++) {
            num1[i]=Integer.parseInt(str1.substring(i,i+1));
        }
        for(int i=0;i<str2.length();i++) {
            num2[i]=Integer.parseInt(str2.substring(i,i+1));
        }
        //用两个循环，实现第一个数组的位分别相乘第二数组的位
        /*
         * 以12*789为例
         * num1是[1,2]
         * num2是[7,8,9]
         * 那么，i=1的时候。result_1是[7,8,9]
         * i=2的时候，result_2是[0,14,16,18]
         * 然后二者相加，result是[7,22,24,18](未进制的)
         */
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                result[i+j]+=num1[i]*num2[j];
            }
        }
        //实现进制
        /*
         * 逆序进制，从下标大的开始往前面进制
         *"/"取整符号，"/10"整除于十，取高位数
         *"%"取模，"%10"对十求模，取低位数
         */
        int temp;
        for (int i = result.length-1; i >0 ; i--) {
            temp=result[i]/10;
            //把高位数用中间数存放起来
            result[i-1]+=temp;
            //把前一位数跟中间数temp相加
            result[i]=result[i]%10;
            //取低位数
        }
        //把进制后的数组遍历出来,实际上是把数组里面的数都给组合起来
        for(int i=0;i<result.length-1;i++) {
            System.out.print(result[i]);
        }
    }
}

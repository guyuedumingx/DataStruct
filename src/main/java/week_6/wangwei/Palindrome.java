package week_6.wangwei;

import util.wangwei.MyStack;

/**
 * 验证回文串
 * @author yohoyes
 */
public class Palindrome {

    /**
     * 指针实现
     * @param str
     * @return
     */
    public static boolean isPalindromeForNeedle(String str){
        char[] chars = str.toCharArray();
        int left = 0, right = str.length()-1;
        for (;(left<=right)&&chars[left]==chars[right];left++,right--){}
        if(right>left) {
            return false;
        }
        return true;
    }

    /**
     * 栈实现
     * @param str
     * @return
     */
    public static boolean isPalindromeForStack(String str){
        char[] chars = str.toCharArray();
        MyStack<Character> stack = new MyStack<Character>();
        for(int i=0; i<chars.length/2;i++){
           stack.push(chars[i]);
        }
        int flag = 0;
        if(chars.length/2==0){
            flag = chars.length/2;
        }else {
            flag = chars.length/2 + 1;
        }
        for(int i=flag; i<chars.length; i++){
            if(chars[i]!=stack.pop()){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        boolean palindrome = isPalindromeForNeedle("1123211");
        boolean palindromeStack = isPalindromeForStack("11211");
        System.out.println(palindrome);
        System.out.println(palindromeStack);
    }
}

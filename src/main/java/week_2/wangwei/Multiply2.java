package week_2;


/**
 * 代码可行
 * 我自己都没搞懂
 * getBitArray函数在方法一(Multiply)里
 * parseArr函数在方法一(Multiply)里
 * @author wangwei
 */
public class Multiply2 {
    public static void main(String[] args) {
        int[] num1 = Multiply.getBitArray("234");
        int[] num2 = Multiply.getBitArray("12358");
        int[] sum = sum = new int[num1.length+num2.length];
        for (int i=0; i<num1.length; i++) {
            int carry = 0;
            for (int n=0; n<num2.length; n++) {
            sum[i+n] += num2[n] * num1[i] + carry;
            carry = sum[i+n] / 10;
            sum[i+n] = sum[i+n] % 10;
            }
        }
        String s = Multiply.parseArray(sum);
        System.out.println(s);
    }
}

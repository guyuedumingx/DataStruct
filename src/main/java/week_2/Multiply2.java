package week_2;

import java.util.Arrays;

public class Multiply2 {
    public static void main(String[] args) {
        int[] num1 = Multiply.getBitArray("234");
        int[] num2 = Multiply.getBitArray("12358");
        int[] sum = sum = Arrays.copyOf(num1,num1.length+num2.length);
        for (int i=0; i<num1.length; i++) {
            for (int n=0; n<num2.length; n++) {
                sum[i+n] += sum[i] * num2[n];
                sum[i+1+n] += sum[i+n] / 10;
                sum[i+n] = sum[i+n] % 10;
            }
        }
        Multiply.parseArray(sum);
    }
}

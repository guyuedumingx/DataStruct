package week_2;


import java.util.Arrays;

public class Multiply {
    public static void main(String[] args) {
        int[] x = getBitArray("3456");
        int[] y = getBitArray("213");
        int[] sum = multiply(x,y[0]);
        for(int i=1; i<3; i++) {
            int[] res = multiply(x, y[i]);
            sum = add(sum, res,i);
        }

    }

    public static int[] getBitArray(String str) {
        char[] stringArr = str.toCharArray();
        int len = stringArr.length;
        int[] nums = new int[len];

        for(int i=0; i<len; i++) {
            nums[len-i-1] = Integer.parseInt(String.valueOf(stringArr[i]));
        }
        return nums;
    }

    public static int[] multiply(int[]x, int y) {
        int carry = 0;
        int[] mul = Arrays.copyOf(x, x.length+1);
        for(int i=0; i<mul.length; i++) {
            int sum = y * mul[i] + carry;
            carry = sum / 10;
            mul[i] = sum % 10;
        }
        return mul;
    }
    public static int[] add(int[] x, int[] y, int offset) {
        int digit = x.length>y.length ? x.length:y.length;
        int[] sum = new int[digit+1];
        int carry = 0;
        for(int i=0; i<digit; i++) {
            int num1 = i>x.length ? 0 : x[i];
            int num2 = i-offset<0 ? 0 : y[i-offset];
            sum[i] = (num1+num2+carry) % 10;
            carry = (num1+num2+carry) / 10;
        }
        return sum;
    }
}

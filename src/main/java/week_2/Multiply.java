package week_2;


import java.util.Arrays;

/**
 * 该类用数组模拟乘法操作
 * 3456 × 213 =
 *  3456 × 3 + 3456 × 1 × 10 + 3456 × 2 × 100
 *
 *  一个数 %10 则得到这个数的最低位
 *  一个数 /10 则得到这个数除去最低位的其余位
 * @author wangwei
 */
public class Multiply {
    public static void main(String[] args) {
        int[] x = getBitArray("3456");
        int[] y = getBitArray("213");

        int[] sum = multiply(x,y[0]);
        for(int i=1; i<3; i++) {
            int[] res = multiply(x, y[i]);
            sum = add(sum, res,i);
        }
        String s = parseArray(sum);
        System.out.println(s);
    }

    /**
     *  getBitArray()函数先将输入的数字字符串转化为一个char数组 3456 -> ['3','4','5','6']
     *  再将该数组中的每一位char通过String.valueOf获取到char对应的数，再使用Integer.parseInt()方法将
     *  该值解析为int型
     *  把int值倒序保存到nums数组中返回  ['3','4','5','6'] -> [6,5,4,3]
     * @param str  输入的String数字
     * @return 返回的nums数组
     */
    public static int[] getBitArray(String str) {
        char[] stringArr = str.toCharArray();
        int len = stringArr.length;
        int[] nums = new int[len];

        for(int i=0; i<len; i++) {
            nums[len-i-1] = Integer.parseInt(String.valueOf(stringArr[i]));
        }
        return nums;
    }

    /**
     * 输入的x 数组将会被Arrays.copyOf复制一份,防止修改x数组本身的值
     * 复制的数组mul比x数组多一位是因为考虑到做乘法后可能接收到前位的进位
     * 将数组中的每一位都乘以y值,如果有进位，则保存在carry中，参与下一位的计算
     * x = [6, 5, 4, 3]
     * y = 3
     * [6, 5, 4, 3] * 3 =
     * [8, 6, 3, 0, 1]  本位的值
     *  1  1  1  1    carry(进位)
     * @param x  输入的需要参与运算的数组
     * @param y  参与运算的y值
     * @return
     */
    public static int[] multiply(int[]x, int y) {
        int carry = 0;
        //复制数组
        int[] mul = Arrays.copyOf(x, x.length+1);
        for(int i=0; i<mul.length; i++) {
            int sum = y * mul[i] + carry;
            carry = sum / 10;
            mul[i] = sum % 10;
        }
        return mul;
    }

    /**
     * 两个数组相加
     * offset: 1  即y数组的第一位与x数组的第二位相加,而不是x数组的第一位
     * digit: 选取x,y两数组中长度最长的数组+1作为和数组的长度，防止和数组sum由于地位的进位导致溢出
     * carry: 进位
     * x:    [6, 5, 4, 3]
     * y:    [4, 3, 5]
     *       ------------
     * sum:[1,0, 8, 9, 3]
     * @param x 参与运算的x数组
     * @param y 参与运算的y数组
     * @param offset 偏移量
     * @return 返回x,y的和
     */
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

    /**
     * 把输入的数组arr转换成String
     * [6,5,4,3] -> "3456"
     * 从后向前遍历数组，如果数组前几位是0则跳过(生成的数最高位不能是0)
     *
     * @param arr 需要转换的数组arr
     * @return 返回的String 数字
     */
    public static String parseArray(int[] arr) {
        StringBuilder str = null;
        for (int i=arr.length-1; i >= 0; i--) {
            if(arr[i]!=0 && str==null) {
                str = new StringBuilder().append(arr[i]);
            } else if(str != null) {
                str.append(arr[i]);
            }
        }
        return str.toString();
    }
}

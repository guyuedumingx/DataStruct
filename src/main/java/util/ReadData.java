package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 读取resource中的数据
 * @author yohoyes
 */
public class ReadData {

    /**
     * 从datafile.txt文件中获取需要排序的数字，datafile.txt文件在resources文件夹下
     * @param number 需要从文件中读取的数字数量
     * @return 返回读取的int[]数组
     * @throws FileNotFoundException 找不到datafile.txt文件
     */
    public static int[] getNumbers(int number) {
        Scanner in;
        try {
            String path = ReadData.class.getClassLoader().getResource("datafile.txt").getPath();
            in = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("找不到datafile.txt");
        }
        String str = in.next();
        //把datafile.txt中的数字按，分割成String 数组
        String[] split = str.split(",");

        int[] nums = new int[number];

        //读取前number位数字
        for(int i=0; i<number;i++) {
            nums[i] = Integer.valueOf(split[i]);
        }
        return nums;
    }
}

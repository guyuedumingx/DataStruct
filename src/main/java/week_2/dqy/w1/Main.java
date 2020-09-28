//赌神洗牌
package week_2.dqy.w1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner src=new Scanner(System.in);
        int[] arr=new int[53];
        for (int i=0;i<52;i++) {
            arr[i] = i+1;
        }
        int[] newArr=new int[53];
        for (int i=0,j=0;i<26;i++,j+=2)
        {
            newArr[j]=arr[i];
            newArr[j+1]=arr[i+26];
        }
        for (int i=0;i<52;i++)
        {
            System.out.print(newArr[i]+" ");
        }
    }
}

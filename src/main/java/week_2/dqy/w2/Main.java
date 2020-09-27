//荷官洗牌
package week_2.dqy.w2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner src=new Scanner(System.in);
        int[] arr=new int[53];
        for (int i=0;i<52;i++) {
            arr[i] = i+1;
        }
        int[] newArr=new int[53];
        int fen=(int)(-8+Math.random()*17);
        System.out.println(fen);
        int lenLeft=26+fen;
        int lenRight=26-fen;
        int i=0,j=0;
        if (fen>0)
        {
            for (;i<lenRight;i++,j+=2)
            {
                newArr[j]=arr[i];
                newArr[j+1]=arr[i+26+fen];
            }
            for (;i<52-lenRight;i++,j++)
            {
                newArr[j]=arr[i];
            }
        }
        else
        {
            for (;i<lenLeft;i++,j+=2)
            {
                newArr[j]=arr[i];
                newArr[j+1]=arr[i+26+fen];
            }
            for (;i<52-lenLeft;i++,j++)
            {
                newArr[j]=arr[i+26+fen];
            }
        }
        for (i=0;i<52;i++) {
            System.out.print(newArr[i]+" ");
        }
    }
}
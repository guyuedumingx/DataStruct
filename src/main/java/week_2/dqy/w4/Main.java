//反转数组
package week_2.dqy.w4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner src=new Scanner(System.in);
        int[] arr=new int[200];
        int n;
        n=src.nextInt();
        for (int i=0;i<n;i++) {
            arr[i]=src.nextInt();
        }
        int i=0,j=n-1;
        while (i<j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;j--;
        }
        for (i=0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

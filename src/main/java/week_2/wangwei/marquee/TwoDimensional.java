package week_2.wangwei.marquee;

public class TwoDimensional {
    private int step = 2;
    private int length = 6;
    private int[][] arr = createArray(length);
    private int[][] res = new int[length][length];

    public static void main(String[] args) {
    }

    private int goRight(int[][] arr,int i,int j) {
        if(j==arr.length) {
            while (j>0) {

            }
        }
    }

    public static int[][] createArray(int length) {
        int[][] arr =  new int[length][length];
        int n = 1;
        for(int i=0;i<length;i++) {
            for(int j=0; j<length; j++) {
                arr[i][j] = n++;
            }
        }
        return arr;
    }

    public static void prt(int[][] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print("[");
           for (int j=0; j<arr[i].length; j++) {
               System.out.print(arr[i][j]+"\t");
           }
            System.out.println("]");
        }
    }

}

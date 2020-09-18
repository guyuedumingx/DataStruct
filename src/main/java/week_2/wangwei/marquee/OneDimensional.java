package week_2.wangwei.marquee;

public class OneDimensional {
    public static void main(String[] args) {
        int[] arr = createArray(200);
        int[] run = run(arr, 3);
        prt(run);
    }

    public static int[] createArray(int length) {
        int[] arr = new int[length];
        for(int i=0; i<length; i++) {
            arr[i] = i+1;
        }
        return arr;
    }

    private static int[] run(int[] arr, int step) {
        int[] res = new int[arr.length];
        int i = 0;
        int j = 0;
        int first = arr[0];
        while (!(res[0]==first && i==arr.length)) {
            if(i==arr.length) {
                prt(res);
                arr = res;
                res = new int[arr.length];
                i = 0;
                j = 0;
            }

            j = (i+step)%arr.length;
            res[j] = arr[i++];
        }
        return res;
    }

    private static void prt(int[] arr) {
        System.out.print("[");
        for(int u: arr) {
            System.out.print(u+"\t");
        }
        System.out.println("]");
    }
}

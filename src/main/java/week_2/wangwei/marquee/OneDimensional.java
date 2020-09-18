package week_2.wangwei.marquee;

public class OneDimensional {
    public static void main(String[] args) {
        int[] arr = createArray(10);
        run(arr,3);
    }

    public static int[] createArray(int length) {
        int[] arr = new int[length];
        for(int i=0; i<length; i++) {
            arr[i] = i+1;
        }
        return arr;
    }

    private static void run(int[] arr, int step) {
        int[] res = new int[arr.length];
        int i = 0;
        int j = 0;
        do {
            if(i==arr.length) {
                arr = res;
                res = new int[arr.length];
                i = 0;
            }

            j = (i+step)%arr.length;
            res[j] = arr[i++];
        }
        while (arr[0] != res[0]);
        for(int u: res) {
            System.out.println(u);
        }
    }
}

package week_11.wangwei;

/**
 * 让命运决定谁是爸爸
 * @author yohoyes
 */
public class RandomChange {

    public static void main(String[] args) {
    }

    /**
     * 产生0-2的随机数
     * @return
     */
    private static int createRandom(){
        return  (int) (Math.random() * 3);
    }
}

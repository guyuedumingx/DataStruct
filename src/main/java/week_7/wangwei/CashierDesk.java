package week_7.wangwei;

import util.wangwei.MyQueue;

import java.util.Random;

/**
 * 模拟收银台
 * @author hoyoyes
 */
public class CashierDesk {
    public static void main(String[] args) {
        MyQueue<People> queue = new MyQueue<People>();
        init(queue);
        do{
            double addNumber = poissonInteger(3);
            int operaNumber = timesInteger(2);
            for(int i=0; i<operaNumber&&queue.getSize()>0;i++){
                queue.poll();
            }
            if(queue.getSize()<=0){break;}
            for(int i=0; i<addNumber&&queue.getSize()<20; i++){
                queue.offer(new People());
            }
        }while (!queue.isEmpty()&&queue.getSize()<20);
        System.out.println(queue.getSize());
    }

    private static void init(MyQueue<People> queue){
        double addNumber = poissonInteger(3);
        for(int i=0; i<addNumber&&queue.getSize()<20; i++){
            queue.offer(new People());
        }
    }

    /**
     * 利用泊松分布产生随机数
     * @param lambda
     * @return
     */
    public static double poissonInteger(int lambda){
        double x=0,b=1,c=Math.exp(-lambda),u;
        do {
            u=Math.random();
            b *=u;
            if(b>=c) {
                x++;
            }
        }while(b>=c);
        return Math.ceil(x);
    }

    /**
     * 利用指数分布产生随机数
     * @param lambda
     * @return
     */
    public static int timesInteger(int lambda){
            Random random = new Random();
            double u = random.nextDouble();
            int x = 0;
            double cdf = 0;
            while (u >= cdf) {
                x ++;
                cdf = 1 - Math.exp(-1.0 * lambda * x);
            }
            return x;
    }
}

class People{
    String name;
    String age;
}

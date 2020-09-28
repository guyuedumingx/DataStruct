package week_2.wuyanzhen;

import java.util.Arrays;

/**
 * @author Florence
 * 1
 */
public class Week2 {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
//        houseRideLightOneDimension(getOneDimensionNumArr(100),8);
//        houseRideLightTwoDimension(getTwoDimensionNumArr(0,11),7,11);
//        houseRideLightThreeDimension(1,1,1,2);
//        shuffleCardsDUSHEN(getNewCards(52));
//        shuffleCardsHEGUAN(getNewCards(52));
//        shuffleCardsPUTONGREN(getNewCards(52));
//        Integer[] test= getNewCards(52);
//        System.out.println("inverseBefore:"+Arrays.toString(test));
//        inverseArr(test);
//        System.out.println("inverseAfter:"+Arrays.toString(test));
        long endTime=System.currentTimeMillis();
        System.out.println("run time : "+(endTime-startTime)+"ms");
    }

    /**
     * 一维跑马灯
     * @param arr 要跳转的数组
     * @param step 步长
     */
    public static void houseRideLightOneDimension(int[] arr,int step){
        int arrLength=arr.length;
        int count=0;
        int firstElement=arr[0];
        int[] tempArr = new int[arrLength];
        do {
            for (int i = 0; i < arrLength; i++) {
                //循坏跳转表达式
                tempArr[(i + step) % arrLength] = arr[i];
            }
            //每次跳转完一次保存跳完的结果，然后再迭代
            System.arraycopy(tempArr, 0, arr, 0, arrLength);
            count++;
            System.out.println(Arrays.toString(arr));
        } while (arr[0] != firstElement);
        System.out.println("总共循坏次数:"+count);
    }

    /**
     * 二维跑马灯（偶数边长简化版）
     * @param arr 数组
     * @param step 步长
     * @param n 边长
     */
    public static void houseRideLightTwoDimension(int[][] arr,int step,int n){
        int[][] tempArr = new int[n][n];
        copyArrTwoDimension(arr,tempArr);
        int count=0;
        for (int i=0;i<(n/2)-step/2;i++){
            int firstElement=arr[i][i];
            do {
                rowForWardOrBackWard(i, i, true, step, arr, tempArr,"down",i);
//                showTwoDimensionArr(tempArr);
                colDownWardOrUpWard(i, n-i-1, false, step, arr, tempArr,"left",i);
//                showTwoDimensionArr(tempArr);
                rowForWardOrBackWard(n - i - 1, n - i - 1, false, step, arr, tempArr,"up",i);
//                showTwoDimensionArr(tempArr);
                colDownWardOrUpWard(n-i-1, i, true, step, arr, tempArr,"right",i);
//                showTwoDimensionArr(tempArr);
                copyArrTwoDimension(tempArr, arr);
                count++;
                System.out.println("第"+count+"次");
                showTwoDimensionArr(arr);
            } while (arr[i][i] != firstElement);
            System.out.println("第"+(i+1)+"圈完成");
        }
        System.out.println("总共旋转："+count+"次");
        System.out.println("跑马灯完成：");
        showTwoDimensionArr(arr);
    }

    /**
     * 行前进或者后退
     * @param beginX 起点x坐标
     * @param beginY 起点y坐标
     * @param mark true为前进，false为后退
     * @param sourceArr 原来未旋转数组
     * @param overLoadDirection 如果溢出的话，要转换的方向 相应的英语代表的就是相应的意思
     * @param tempArr 临时存储数组
     */
    public static void rowForWardOrBackWard(int beginX,int beginY,boolean mark,int step,int[][] sourceArr,int[][] tempArr,String overLoadDirection,int times){
        int length=sourceArr.length;
        //前进
        if(mark) {
            for (int i = beginY; i < length-beginY; i++) {
                //不越界
                if (i+step<length-beginY){
                    tempArr[beginX][i+step]=sourceArr[beginX][i];
                }
                //如果超出我们选择的长度，那么就要进行旋转，旋转的方向可以有上有下，根据条件决定
                else {
                    int gap = (i + step) - length + 1+times;
                    if ("down".equals(overLoadDirection)) {
                        tempArr[beginX+gap][length-beginY-1] = sourceArr[beginX][i];
                    }
                    else if("up".equals(overLoadDirection)){
                        tempArr[beginX-gap][length-beginY-1] = sourceArr[beginX][i];
                    }
                }
            }
        }
        //后退
        else {
            for (int i=beginY;i>=(length-beginY-1);i--){
                //不越界
                if(i-step>=length-beginY-1){
                    tempArr[beginX][i-step]=sourceArr[beginX][i];
                }
                else {
                    int gap =step-i+length-beginY-1;
                    if ("down".equals(overLoadDirection)){
                        tempArr[beginX+gap][length-beginY-1]=sourceArr[beginX][i];
                    }
                    else if("up".equals(overLoadDirection)){
                        tempArr[beginX-gap][length-beginY-1]=sourceArr[beginX][i];
                    }
                }
            }
        }
    }

    /**
     *列上升或者下降
     * @param beginX 起点X
     * @param beginY 起点Y
     * @param mark true为向上，false为后退
     * @param sourceArr 原来未旋转数组
     * @param tempArr 临时存储数组
     * @param overLoadDirection 如果溢出的话，要转换的方向 相应的英语代表的就是相应的意思
     */
    public static void colDownWardOrUpWard(int beginX,int beginY,boolean mark,int step,int[][] sourceArr,int[][] tempArr,String overLoadDirection,int times){
            int length=sourceArr.length;
            //向上移动
            if (mark){
                for (int i=beginX;i>=length-beginX-1;i--) {
                    //不越界
                    if (i-step>=length-beginX-1) {
                        tempArr[i - step][beginY] = sourceArr[i][beginY];
                    }
                    //越界旋转
                    else {
                        int gap=step-i+length-beginX-1;
                        if("left".equals(overLoadDirection)){
                            tempArr[length-beginX-1][beginY-gap]=sourceArr[i][beginY];
                        }
                        else if ("right".equals(overLoadDirection)){
                            tempArr[length-beginX-1][beginY+gap]=sourceArr[i][beginY];
                        }
                    }
                }
            }
            //向下移动
            else{
                for (int i=beginX;i<length-beginX;i++) {
                    //不越界
                    if (i+step<length-beginX) {
                        tempArr[i+step][beginY] = sourceArr[i][beginY];
                    }
                    //越界旋转
                    else {
                        int gap=(step+i)-length+1+times;
                        if("left".equals(overLoadDirection)){
                            tempArr[length-beginX-1][beginY-gap]=sourceArr[i][beginY];
                        }
                        else if ("right".equals(overLoadDirection)){
                            tempArr[length-beginX-1][beginY+gap]=sourceArr[i][beginY];
                        }
                    }
                }
            }
    }

    /**
     * 三维跑马灯,固定那个轴，哪个轴相应的坐标就是一定不变的
     * @param x 固定x轴转yoz平面几次
     * @param y 固定y轴转xoz平面几次
     * @param z 固定z轴转xoy平面几次
     */
    public static void houseRideLightThreeDimension(int x,int y,int z,int step){
        int[][][] resultArr= getThreeDimensionNumArr(3);
        int[][][] tempArr=getThreeDimensionNumArr(3);
        //xoy: resultArr[0] yoz :resultArr[?][0][?]   xoz:resultArr[?][?][0]
        //固定x轴的就是yoz面
        for (int i=0;i<x;i++){
                fixXround(tempArr,resultArr,step);
                copyArrThreeDimension(tempArr,resultArr);
        }
        //固定y轴就是xoz平面
        for(int i=0;i<y;i++){
                fixYround(tempArr,resultArr,step);
                copyArrThreeDimension(tempArr,resultArr);
        }
        //固定z轴就是xoy平面
        for (int i=0;i<z;i++){
                fixZround(tempArr,resultArr,step);
                copyArrThreeDimension(tempArr,resultArr);
        }
        showThreeDimension(resultArr);
    }
    /**
     * 固定Y旋转
     * @param tempArr 暂时的数组
     * @param resultArr 结果数组
     * @param step 步长
     */
    private static void fixYround(int[][][] tempArr, int[][][] resultArr, int step) {
        //向右
        for (int i=0;i<3;i++){
            if (i+step<3){
                tempArr[0][i+step][0]=resultArr[0][i][0];
            }
            else{
                int gap=i+step-3+1;
                tempArr[0+gap][2][0]=resultArr[0][i][0];
            }
        }
        //向下
        for (int i=0;i<3;i++){
            if (i+step<3){
                tempArr[i+step][2][0]=resultArr[i][2][0];
            }
            else{
                int gap=i+step-3+1;
                tempArr[2][2-gap][0]=resultArr[i][2][0];
            }
        }
        //向左
        for (int i=2;i>=0;i--){
            if(i-step>=0){
                tempArr[2][i-step][0]=resultArr[2][i][0];
            }
            else{
                int gap=step-i;
                tempArr[2-gap][0][0]=resultArr[2][i][0];
            }
        }
        //向上
        for (int i=2;i>=0;i--){
            if (i-step>=0){
                tempArr[i-step][0][0]=resultArr[i][0][0];
            }
            else {
                int gap=step-i;
                tempArr[0][0+gap][0]=resultArr[i][0][0];
            }
        }
    }
    /**
     * 固定X旋转
     * @param tempArr 暂时的数组
     * @param resultArr 结果数组
     * @param step 步长
     */
    private static void fixXround(int[][][] tempArr, int[][][] resultArr, int step) {
        //向右
        for (int i=0;i<3;i++){
            if (i+step<3){
                tempArr[0][0][i+step]=resultArr[0][0][i];
            }
            else{
                int gap=i+step-3+1;
                tempArr[0+gap][0][2]=resultArr[0][0][i];
            }
        }
        //向下
        for (int i=0;i<3;i++){
            if (i+step<3){
                tempArr[i+step][0][2]=resultArr[i][0][2];
            }
            else{
                int gap=i+step-3+1;
                tempArr[2][0][2-gap]=resultArr[i][0][2];
            }
        }
        //向左
        for (int i=2;i>=0;i--){
            if(i-step>=0){
                tempArr[2][0][i-step]=resultArr[2][0][i];
            }
            else{
                int gap=step-i;
                tempArr[2-gap][0][0]=resultArr[2][0][i];
            }
        }
        //向上
        for (int i=2;i>=0;i--){
            if (i-step>=0){
                tempArr[i-step][0][0]=resultArr[i][0][0];
            }
            else {
                int gap=step-i;
                tempArr[0][0][0+gap]=resultArr[i][0][0];
            }
        }
    }

    /**
     * 固定z旋转
     * @param tempArr 暂时的数组
     * @param resultArr 结果数组
     * @param step 步长
     */
    private static void fixZround(int[][][] tempArr, int[][][] resultArr, int step) {
        //前进
        for (int i=0;i<3;i++){
             if(i+step<3){
                 tempArr[0][0][i+step]=resultArr[0][0][i];
             }
             else {
                 int gap = i+step-3+1;
                 tempArr[0][0+gap][2]=resultArr[0][0][i];
             }
        }
        //向下
        for (int i=0;i<3;i++){
            if (i+step<3){
                tempArr[0][i+step][2]=resultArr[0][i][2];
            }
            else{
                int gap =i+step-3+1;
                tempArr[0][2][2-gap]=resultArr[0][i][2];
            }
        }
        //向左
        for (int i=2;i>=0;i--){
            if (i-step>=0){
                tempArr[0][2][i-step]=resultArr[0][2][i];
            }
            else{
                int gap=step-i;
                tempArr[0][2-gap][0]=resultArr[0][2][i];
            }
        }
        //向上
        for (int i=2;i>=0;i--){
            if (i-step>=0){
                tempArr[0][i-step][0]=resultArr[0][i][0];
            }
            else {
                int gap=step-i;
                tempArr[0][0][0+gap]=resultArr[0][i][0];
            }
        }
    }

    /**
     * 获取一维测试数组
     * @param n 上限
     * @return 得到的数组
     */
    public static int[] getOneDimensionNumArr(int begin,int n){
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=begin+i+1;
        }
        return arr;
    }

    /**
     * 获取二维数组
     * @param n 要的大小
     * @param begin 二维数组开始的值
     * @return 获取到的二维数组
     */
    public static int[][] getTwoDimensionNumArr(int begin,int n){
        int[][] arr = new int[n][n];
        for (int i=0;i<n;i++){
            arr[i]=getOneDimensionNumArr(n*i+begin,n);
        }
        return arr;
    }

    /**
     * 获取三维数组 n*n*n
     * @param n 二维数组的大小
     * @return 获取到的三维数组
     */
    public static int[][][] getThreeDimensionNumArr(int n){
        int[][][] arr = new int[n][n][n];
        for (int i=0;i<n;i++){
            arr[i]=getTwoDimensionNumArr(n*n*i,n);
        }
        return arr;
    }

    /**
     * 展示我们的二维数组
     * @param arr 展示的二维数组
     */
    public static void showTwoDimensionArr(int[][] arr){
        for (int[] subArr:arr){
            System.out.println(Arrays.toString(subArr));
        }
        System.out.println("**************************************************");
    }
    public static void showThreeDimension(int[][][] arr){
        for (int[][] subArr:arr){
            showTwoDimensionArr(subArr);
        }
    }
    public static int[][] copyArrTwoDimension(int[][] sourceArr,int[][] wantToCopyArr){
        for (int i=0;i<sourceArr.length;i++){
            System.arraycopy(sourceArr[i],0,wantToCopyArr[i],0,sourceArr[i].length);
        }
        return wantToCopyArr;
    }
    public static int[][][] copyArrThreeDimension(int [][][] sourceArr,int[][][] wantToCopyArr){
        for (int i=0;i<sourceArr.length;i++){
            copyArrTwoDimension(sourceArr[i],wantToCopyArr[i]);
        }
        return wantToCopyArr;
    }


    /**
     * 洗牌赌神版
     * @param arr 待洗牌的数组
     * @return 洗完的数组地址
     */
    public static Integer[] shuffleCardsDUSHEN(Integer[] arr){
        int gap=arr.length/2;
        int pointer=0;
        System.out.println("赌神洗牌前："+Arrays.toString(arr));
        Integer[] result = new Integer[arr.length];
        for (int i=arr.length/2;i<arr.length;i++){
            result[pointer++]=arr[i];
            result[pointer++]=arr[i-gap];
        }
        System.out.println("赌神洗牌后："+Arrays.toString(result));
        return result;
    }

    /**
     * 洗牌荷官版
     * @param arr 待洗牌的数组
     * @return 洗完的数组地址
     */
    public static Integer[] shuffleCardsHEGUAN(Integer[] arr){
        int midPointer=arr.length/2+getRandomNum(-3,3);
        System.out.println("分割点为下标为："+midPointer);
        int divideBit=midPointer;
        int leftPointer=0,pointer=0;
        System.out.println("荷官洗牌前："+Arrays.toString(arr));

        Integer[] resultArr =new Integer[arr.length];
        while(leftPointer<divideBit&&midPointer<arr.length){
            resultArr[pointer++]=arr[leftPointer++];
            resultArr[pointer++]=arr[midPointer++];
        }
        int remindStartPoint=leftPointer==divideBit?midPointer:leftPointer;
        for (int i=remindStartPoint;pointer<arr.length;i++){
            resultArr[pointer++]=arr[i];
        }
        System.out.println("荷官洗牌后："+Arrays.toString(resultArr));
        return resultArr;
    }

    /**
     * 洗牌普通人版
     * @param arr 要洗牌的数组
     * @return 洗完排后的数组地址
     */
    public static Integer[] shuffleCardsPUTONGREN(Integer[] arr){
        //切牌点误差-10~10
        int dividePosition=arr.length/2+getRandomNum(-10,10);
        int leftPointer=0,midPointer=dividePosition;
        int pointer=0;
        System.out.println("手残洗牌前："+Arrays.toString(arr));
        Integer[] resultArr = new Integer[arr.length];
        System.out.println("分割点为下标为："+midPointer);
        while (leftPointer<dividePosition&&midPointer<arr.length){
            //左边随机下牌0~5
            for (int i=0;leftPointer<dividePosition&&i<getRandomNum(0,5);i++){
                resultArr[pointer++]=arr[leftPointer++];
            }
            //右边随机下牌0~5
            for (int i=0;midPointer<arr.length&&i<getRandomNum(0,5);i++){
                resultArr[pointer++]=arr[midPointer++];
            }
        }
        //判断最后一部分
        int remindStartPoint=leftPointer==dividePosition?midPointer:leftPointer;
        //添加到最后面
        for (int i=remindStartPoint;pointer<arr.length;i++){
            resultArr[pointer++]=arr[i];
        }
        //输出结果
        System.out.println("手残洗牌后："+Arrays.toString(resultArr));
        return resultArr;
    }

    /**
     * 获取随机数   [bottomBound,topBound]
     * @param bottomBound 下界
     * @param topBound 上界
     * @return 获取到的随机数
     */
    public static int getRandomNum(int bottomBound, int topBound){
        int c=topBound-bottomBound+1;
        double x=Math.random()*c;
        int y=(int)x;
        return y+bottomBound;
    }

    /**
     * 数组交换元素
     * @param arr 要交换元素的数组地址
     * @param index1 下标一
     * @param index2 下标二
     * @param <T> 泛型数组
     */
    public static <T> void swap(T[] arr,int index1,int index2){
        T temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
    /**
     * 倒置算法
     * @param object 具体的对象数组
     * @param <T> 对象类型
     * @return 反转后的数组地址
     */
    private static <T> T[] inverseArr(T[] object){
        int left=0,right=object.length-1;
        while(left<right){
            T temp = object[left];
            object[left]=object[right];
            object[right]=temp;
            left++;
            right--;
        }
        return object;
    }
    /**
     * 获取一幅数量为n的卡牌
     * @param n 卡牌的数量
     * @return 返回获得的数组
     */
    public static Integer[] getNewCards(int n){
        Integer[] cards = new Integer[n];
        for (int i=0;i<n;i++){
            cards[i]=i+1;
        }
        return  cards;
    }
}

package com.Sort;

import java.util.Arrays;
import java.util.Date;

public class SelectSort extends  SortFather {
    private String name;
    private String time;
    private int []ownArr;

    public int getChangeCount() {
        return ChangeCount;
    }

    private int ChangeCount;


    public SelectSort(){
        this.name = "选择排序";
        this.time = "";
        this.ChangeCount = 0;
    }


    @Override
    public void work() {


//        //首先大循环
//        for (int i = 0;i<arr.length-1;i++) {
//            //当前arr最小值的位置
//            int  minIndex = i;
//            //假设当前最小值为arr[i]
//            int min = arr[i];
//
//            for (int j = i + 1; j < arr.length; j++) {
//                //如果当前arr中有比我min还小的，就让min等于它
//                //并把minIndex的值更新为这个的位置
//                if (min >= arr[j]) {
//                    min = arr[j];
//                    minIndex = j;
//                }
//            }
//            //如果minIndex的值本来就是当前队列的第一个，说明最小值已经在第一位了，就不用转换，
//            //否则就进入if语句
//            if(minIndex!=i) {
//                //把arr[i]的值和arr[minIndex]做交换
//                arr[minIndex] = arr[i];
//                arr[i] = min;
//            }
//            System.out.println("第"+(i+1)+"轮结束，解过为"+ Arrays.toString(arr));
//        }
//

//        大循环
        for(int i = 0;i<ownArr.length-1;i++){

//          首先定一个为最小值，假设他为最小值
            int min = ownArr[i];
//          最小值索引
            int minIndex = i;

//           第二层循环
            for(int j = i+1;j<ownArr.length;j++){
//                判断，如果当前的最小值比j的值要大，就把最小值索引设置为j
                if(min >= ownArr[j]){
                    this.ChangeCount ++;
                    min = ownArr[j];
                    minIndex = j;
                }
            }

//          判断，如果minIndex是当前i次循环的第一个的话，说明当前第一个就是最小值，就不用交换，
//          如果不是，就交换
            if(minIndex != i){
                ownArr[minIndex] = ownArr[i];
                this.ChangeCount ++;
                ownArr[i] = min;
            }

        }
    }

    /**
     * 把父类的数组保存到子类里面
     */
    public void Copy(){
        this.ownArr = new int[SortFather.getCount()];
        for(int i = 0; i< SortFather.getCount(); i++){
            ownArr[i] = super.arr[i];
        }
    }


    /**
     * 输出数组
     */

    public void printArray(){
        System.out.println("\n数组为：");
        for(int i = 0;i<ownArr.length-1;i++){
            System.out.printf("%d\t",ownArr[i]);
        }
        System.out.println("");
    }
    /**
     * 表明身份
     */
    public void sayHello(){
        System.out.println(this.name);
    }



    /**
     * 获取系统当前时间
     * @return 返回long
     */
    @Override
    public long getTime() {

        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        long time = date.getTime();
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

}

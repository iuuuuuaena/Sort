package com.Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ButtleSort extends SortFather {

    /**
     * name
     * time
     * ChangeCount :关键字比较次数
     */
    private String name;
    private String time;
    private int [] ownArr;
    private int ChangeCount;

    public  int getChangeCount() {
        return ChangeCount;
    }

    public ButtleSort(){
        this.name = "冒泡排序";
        this.time = "0";
        this.ChangeCount = 0;

    }

    /**
     * 排序算法
     */
    @Override
    public void work(){

        //临时变量，用于交换两个位置
        int temp = 0;
        //用于判断是否已经完成交换,避免过多的时间空间复杂度
        boolean flag  = false;
        //第一层循环！！！遍历
        for(int i= 0;i<ownArr.length;i++){
            //第二层循环！！！一次一次确定最大值！
            for(int j = 0;j<ownArr.length-1-i;j++){
                //如果前面的值比后面的大，就交换位置
                if(ownArr[j]>ownArr[j+1]){
                    flag= true;
                    temp = ownArr[j];
                    this.ChangeCount++;
                    ownArr[j] = ownArr[j+1];
                    ownArr[j+1] = temp;
                }
            }
//            System.out.println("第"+(i+1)+"次遍历，结果为"+ Arrays.toString(arr));
            if(!flag){
                break;
            }else {
                flag = false;
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
     * 表明身份
     */
    public void sayHello(){
        System.out.println(this.name);
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
     * 获取系统当前时间
     * @return 返回long
     */
    @Override
    public long getTime() {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
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

package com.Sort;

import java.util.Date;

public class ShellSort extends SortFather {


    private String name;
    private String time;
    private int []ownArr;

    public int getChangeCount() {
        return ChangeCount;
    }

    private int ChangeCount;


    public ShellSort(){
        this.name = "希尔排序";
        this.time = "";
        this.ChangeCount = 0;
    }


    @Override
    public void work() {
        int insertVal = 0;
        int insertIndex = 0;
        for(int i = 1 ;i<ownArr.length;i++){
            insertVal = ownArr[i];
            insertIndex = i-1 ;
            while(insertIndex >= 0 && insertVal<ownArr[insertIndex]){
                ownArr[insertIndex+1] = ownArr[insertIndex];
                this.ChangeCount++;
                insertIndex --;
            }
            ownArr[insertIndex+1] = insertVal;
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

package com.Sort;

import java.util.Date;

public class InsertSort extends SortFather {

    private String name;
    private String time;
    private int []ownArr;

    public int getChangeCount() {
        return ChangeCount;
    }

    private int ChangeCount;


    public InsertSort(){
        this.name = "插入排序";
        this.time = "";
        this.ChangeCount = 0;
    }


    @Override
    public void work() {
        /**
         * 思想就是把整个表看成一个有序表和一个无序表，刚开始有序表是0个，然后把无需表一个一个插到有序表中
         * insertVal:是无序表的第一个数保存到insertval中
         * insertIndex：是有序表的最后一位的下标
         */
        int insertVal = 0;
         int insertIndex = 0;
         for(int i = 1 ;i<ownArr.length;i++){
//           首先，将insertVal设置为无序表的第一个
             insertVal = ownArr[i];
//           有序表的最后一位的索引设置为i-1
             insertIndex = i-1 ;
//           依次从有序表最后一位向有序表的第一个循环，如果无需表的第一个小于有序表当前的值
             while(insertIndex >= 0 && insertVal<ownArr[insertIndex]){
//               把无需表的第一位保存在insertVal中
//               把有序表后面增加一位，
                 ownArr[insertIndex+1] = ownArr[insertIndex];
                 this.ChangeCount++;
                 insertIndex --;
             }
//           把保存的加到有序表里
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

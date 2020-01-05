package com.Sort;

import java.text.DateFormat;
import java.util.Date;

public class QuickSort extends SortFather {

    /**
     * name
     * time
     * ChangeCount :关键字比较次数
     */
    private String name;
    private String time;
    private int [] ownArr;
    private int ChangeCount;

    public QuickSort(){
        this.name = "快速排序";
        this.time = "";
        this.ChangeCount = 0;
    }

    public int getChangeCount() {
        return ChangeCount;
    }



    @Override
    public  void work(){
        quickRecursion(this.ownArr, 0,this.ownArr.length-1);

    }


    /**
     * 快排
     * @param arr 要排序的数组
     * @param low   最低位置
     * @param high  最高位置
     */
    public void quickRecursion(int [] arr ,int low  ,int high){
        //temp用来指代基准
        //curr用来当作临时变量，交换
        int i,j,temp,curr;

        if(low>high){
            return;
        }
        i = low;
        j = high;
        temp = arr[low];
        while(i<j){
            while(temp<=arr[j]&&i<j){
                this.ChangeCount ++;
                j--;
            }
            while (temp>=arr[i]&&i<j){
                this.ChangeCount ++;
                i++;
            }
            if(i<j){
                this.ChangeCount ++;
                //把i跟j进行交换，让，比temp大的到右边，比temp小的到左边
                curr = arr[j];
                arr[j] = arr[i];
                arr[i] = curr;
            }
        }


        //最后将基准位置与i和j相等的位置进行交换
        this.ChangeCount ++;
        arr[low] = arr[i];
        arr[i] = temp;
        quickRecursion(arr,low,j-1);
        quickRecursion(arr,j+1,high);
    }
    /**
     * 表明身份
     */
    public void sayHello(){
        System.out.println(this.name);
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


    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
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



    @Override
    public long getTime(){
        Date date = new Date();


        Long time = date.getTime();
        return time;

    }
}

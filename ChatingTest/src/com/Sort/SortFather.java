package com.Sort;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 排序程序抽象父类
 *      抽象方法有：
 *      work()
 *      getTime()
 */
public  abstract class SortFather {
    /**
     * MessageMap：用于储存每一步过程和运行时间结果
     * name : 每个排序函数的名称
     * time : 储存时间
     * arr : 父类储存数组
     * count : 用于设置数组的大小
     * MessageMap:用于存储算法的名称和交换次数
     * doubleMap:用于存储算法名称和运行时间
     */
    private String name;
    private String time;
    public static int []arr;
    public static int count;

    public static Map<String,String> MessageMap = new HashMap<>();
    public static Map<String,Double> doubleMap = new HashMap<>();
    /**
     * 构造函数
     */
    public SortFather() {
        this.name = "我是父亲";
        this.time = "";

    }

    /**
     * 抽象函数
     */
    public abstract void work();

    /**
     * 构建随机数组
     * @return int
     */
    public int [] createArray(){
        this.arr = new int[count];
        for(int i = 0;i<count;i++){
            this.arr[i] = (int)(Math.random() * 800000);//0到800000的随机数
        }
        return this.arr;
    }

    /**
     * 获取当前系统时间
     * @return String
     */
    public static String getDate(){
        //测试时间
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("当前时间为："+date1Str);
        return date1Str;
    }

    /**
     * 输出arr数组
     */
    public static void  getArray(){
        System.out.println("父类的数据为：");
        for(int i = 0;i<arr.length-1;i++){
            System.out.printf("%d\t",arr[i]);
        }

    }

    public abstract long getTime() ;

    public static void setCount(int count) {
        SortFather.count = count;
    }
    public static int getCount() {
        return count;
    }

}
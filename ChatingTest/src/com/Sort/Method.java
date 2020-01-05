package com.Sort;

import static com.Sort.SortFather.MessageMap;
import static com.Sort.SortFather.doubleMap;

public class Method {


    public static String BottleMothod(int count){
        ButtleSort b = new ButtleSort();
        System.out.println("数组大小为" + SortFather.getCount());
        if(count==0){
            count = 10000;
        }
        SortFather.setCount(count);
        System.out.println("数组大小为" + SortFather.getCount());
        b.sayHello();
        b.createArray();
        b.Copy();
        b.printArray();
        long timeStart = b.getTime();
        b.work();
        long timeEnd = b.getTime();
        b.printArray();
        long time = timeEnd-timeStart;
        System.out.println("用时:"+time);
        System.out.println("交换次数为:"+b.getChangeCount());
        MessageMap.put(b.getName(),b.getChangeCount()+"");
        doubleMap.put(b.getName(),(double)time);
        System.out.println("MessageMap为:"+ MessageMap);
        System.out.println("doubleMap为:"+ doubleMap);
        return  "当前是:"+b.getName()+"<br>用时:"+time+"<br>交换次数:"+b.getChangeCount();

    }
    public static String InsertMothod(int count){
        InsertSort i  = new InsertSort();
        if(count==0){
            count = 10000;
        }
        System.out.println("数组大小为" + SortFather.getCount());
        SortFather.setCount(count);
        System.out.println("数组大小为" + SortFather.getCount());
        i.sayHello();
        i.createArray();
        i.Copy();
        i.printArray();
        long timeStart = i.getTime();
        i.work();
        long timeEnd = i.getTime();
        i.printArray();
        long time = timeEnd-timeStart;
        System.out.println("用时:"+time);
        System.out.println("交换次数为:"+i.getChangeCount());
        MessageMap.put(i.getName(),i.getChangeCount()+"");
        doubleMap.put(i.getName(),(double)time);
        System.out.println("MessageMap为:"+ MessageMap);
        System.out.println("doubleMap为:"+ doubleMap);
        return  "当前是:"+i.getName()+"<br>用时:"+time+"<br>交换次数:"+i.getChangeCount();

    }
    public static String SelectMothod(int count){
        SelectSort s  = new SelectSort();
        if(count==0){
            count = 10000;
        }
        System.out.println("数组大小为" + SortFather.getCount());
        SortFather.setCount(count);
        System.out.println("数组大小为" + SortFather.getCount());
        s.sayHello();
        s.createArray();
        s.Copy();
        s.printArray();
        long timeStart = s.getTime();
        s.work();
        long timeEnd = s.getTime();
        s.printArray();
        long time = timeEnd-timeStart;
        System.out.println("用时:"+time);
        System.out.println("交换次数为:"+s.getChangeCount());
        MessageMap.put(s.getName(),s.getChangeCount()+"");
        doubleMap.put(s.getName(),(double)time);
        System.out.println("MessageMap为:"+ MessageMap);
        System.out.println("doubleMap为:"+ doubleMap);
        return  "当前是:"+s.getName()+"<br>用时:"+time+"<br>交换次数:"+s.getChangeCount();

    }
    public static String QuickMothod(int count){
        QuickSort q = new QuickSort();
        if(count==0){
            count = 10000;
        }
        System.out.println("数组大小为" + SortFather.getCount());
        SortFather.setCount(count);
        System.out.println("数组大小为" + SortFather.getCount());
        q.sayHello();
        q.createArray();
        q.Copy();
        q.printArray();
        long timeStart = q.getTime();
        q.work();
        long timeEnd = q.getTime();
        q.printArray();
        long time = timeEnd-timeStart;
        System.out.println("用时:"+time);
        System.out.println("交换次数为:"+q.getChangeCount());
        MessageMap.put(q.getName(),q.getChangeCount()+"");
        doubleMap.put(q.getName(),(double)time);
        System.out.println("MessageMap为:"+ MessageMap);
        System.out.println("doubleMap为:"+ doubleMap);
        return  "当前是:"+q.getName()+"<br>用时:"+time+"<br>交换次数:"+q.getChangeCount();

    }
    public static String ShellMothod(int count){
        ShellSort s = new ShellSort();
        if(count==0){
            count = 10000;
        }
        System.out.println("数组大小为" + SortFather.getCount());
        SortFather.setCount(count);
        System.out.println("数组大小为" + SortFather.getCount());
        s.sayHello();
        s.createArray();
        s.Copy();
        s.printArray();
        long timeStart = s.getTime();
        s.work();
        long timeEnd = s.getTime();
        s.printArray();
        long time = timeEnd-timeStart;
        System.out.println("用时:"+time);
        System.out.println("交换次数为:"+s.getChangeCount());
        MessageMap.put(s.getName(),s.getChangeCount()+"");
        doubleMap.put(s.getName(),(double)time);
        System.out.println("MessageMap为:"+ MessageMap);
        System.out.println("doubleMap为:"+ doubleMap);
        return  "当前是:"+s.getName()+"<br>用时:"+time+"<br>交换次数:"+s.getChangeCount();

    }
    public static String MergeMothod(int count){
        MergeSort m = new MergeSort();
        if(count==0){
            count = 10000;
        }
        System.out.println("数组大小为" + SortFather.getCount());
        SortFather.setCount(count);
        System.out.println("数组大小为" + SortFather.getCount());
        m.sayHello();
        m.createArray();
        m.Copy();
        m.printArray();
        long timeStart = m.getTime();
        m.work();
        long timeEnd = m.getTime();
        m.printArray();
        long time = timeEnd-timeStart;
        System.out.println("用时:"+time);
        System.out.println("交换次数为:"+m.getChangeCount());
        MessageMap.put(m.getName(),m.getChangeCount()+"");
        doubleMap.put(m.getName(),(double)time);
        System.out.println("MessageMap为:"+ MessageMap);
        System.out.println("doubleMap为:"+ doubleMap);
        return  "当前是:"+m.getName()+"<br>用时:"+time+"<br>交换次数:"+m.getChangeCount();

    }
}

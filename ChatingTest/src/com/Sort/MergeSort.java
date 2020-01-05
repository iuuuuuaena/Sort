package com.Sort;

import java.util.Date;

public class MergeSort extends SortFather{
    private String name;
    private String time;
    private int []ownArr;
    private int ChangeCount;
    public int getChangeCount() {
        return ChangeCount;
    }


    public MergeSort(){
        this.name = "归并排序";
        this.time = "";
        this.ChangeCount = 0;
    }


    @Override
    public void work() {
        Merge(this.ownArr,0,this.ownArr.length-1);
    }
//    归并排序
    public  void Merge(int [] arr , int start,int end){
        if(start < end){
//            求中点
            int mid = (start + end)/2;
//            左递归
            Merge(arr,start,mid);
//            右递归
            Merge(arr,mid+1,end);
//            合并两个子串
            Sort2(arr,start,mid,end);

        }

    }

    /**
     * 这是原版，看起来清晰一些
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public void Sort1(int [] arr ,int left,int mid ,int right){
//        创建一个临时的数组
        int [] temp = new int[arr.length];

//      L和M是检测指针
//      tempIndex是存放指针
        int L = left;
        int M = mid+1;
        int tempIndex = left;

        while(L <=mid && M<=right){
            if(arr[L]<=arr[M]){
                temp[tempIndex] = arr[L];
                this.ChangeCount++;
                L++;
            }else {
                temp[tempIndex] = arr[M];
                this.ChangeCount++;
                M++;
            }
        }
//        进行完上面一步之后，如果第一个序列未检测完，则左半边的所有值都小于右边的，然后直接将后面所有元素加到合并的序列中
        while(L<=mid){
            this.ChangeCount++;
            temp[tempIndex]=arr[L];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
            tempIndex++;
            L++;
        }
        while(M<=right) {
            this.ChangeCount++;
            temp[tempIndex]=arr[M];//同上
            tempIndex++;
            L++;
        }
//        把temp复制回原数组
        for(int i = left;i<= right;i++){
            this.ChangeCount++;
            arr[i] = temp[i];

        }
    }

    /**
     * 这个是简化版的，减少了一点代码量
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public void Sort2(int [] arr ,int left,int mid ,int right){
//        创建一个临时的数组
        int [] temp = new int[arr.length];

//      L和M是检测指针
//      tempIndex是存放指针
        int L = left,M = mid+1,tempIndex = left;

        while(L <=mid && M<=right){
            if(arr[L]<=arr[M]){
                temp[tempIndex++] = arr[L++];
                this.ChangeCount++;

            }else {

                temp[tempIndex++] = arr[M++];
                this.ChangeCount++;
            }
        }
        while(L <= mid) {temp[tempIndex++] = arr[L++];  this.ChangeCount++;}
        while(M <= right) {temp[tempIndex++ ] = arr[M++];  this.ChangeCount++;}
        for(int i= left;i<=right;i++){
            this.ChangeCount++;
            arr[i] = temp[i];
            this.ChangeCount++;
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

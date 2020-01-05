package com.Control;

import com.Sort.Method;

import java.awt.*;
import java.util.*;


import static com.Control.MainUI.isNumeric;
import static com.Sort.SortFather.doubleMap;


public class Control {


    public static Map<String,String> returnMes;
    public String type;
    public int count;
    public String re;

    public Control(String type,int count) {
        returnMes = new HashMap<>();
        this.type = type;
        this.count = count;
    }

    public String router() {
        if(this.type == ""){
            return "消息不能为空哦";
        }
        if(isNumeric(this.type)){
            int value = Integer.parseInt(this.type);
            if(this.count>80000){
                this.count = 50000;
            }
            switch (value) {
                case 1:
                    re = Method.BottleMothod(this.count);
                    break;
                case 2:
                    re = Method.InsertMothod(this.count);
                    break;
                case 3:
                    re = Method.SelectMothod(this.count);
                    break;
                case 4:
                    re = Method.QuickMothod(this.count);
                    break;
                case 5:
                    re = Method.ShellMothod(this.count);
                    break;
                case 6:
                    re = Method.MergeMothod(this.count);
                    break;
                default:
                    re = "没有这个功能哦";
                    break;
            }
        }else {
            /**
             * 不是数字就回复
             */
            re = "只能为数字哦！";
        }

        return re;
    }

    public void addMessage(String Key,String Value) {
        returnMes.put(Key,Value);

    }

    public void printChart(){
        Map<String, Map<String, Double>> datas =new HashMap<>();
        //压入数据
        datas.put("交换次数", doubleMap);

        Font font = new Font("宋体", Font.BOLD, 20);

        ChartUI.createPort("算法比较",datas,"时间","数量单位（次数）",font);

    }

    public void showMap() {
        System.out.println("returnMap为："+returnMes);
    }




}
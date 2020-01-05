package com.Control;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 此类用于绘制柱状图
 */

public class ChartUI {

    /**
     *
     * 提供静态方法：获取报表图形：柱状图
     *
     * @param title  柱状图的标题
     * @param datas  数据
     * @param type   分类
     * @param danwei 柱状图的数量单位
     * @param font   字体
     */
    public static void createPort(String title, Map<String, Map<String, Double>> datas, String type, String danwei, Font font) {


        /**
         * 种类数据集
         */
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        //数据迭代器
        Set<Map.Entry<String, Map<String, Double>>> set1 = datas.entrySet(); //总数据

        Iterator iterator1 = set1.iterator();   //开始第一次迭代

        Iterator iterator2 = null;

        HashMap<String, Double> map = null;

        Set<Map.Entry<String, Double>> set2 = null;

        Map.Entry entry1 = null;

        Map.Entry entry2 = null;

        while (iterator1.hasNext()) {
            entry1 = (Map.Entry) iterator1.next();  //遍历分类
            map = (HashMap<String, Double>) entry1.getValue(); //得到每次分类的详细信息

            set2 = map.entrySet();   //获取键值对集合

            iterator2 = set2.iterator();       //再次迭代遍历

            while (iterator2.hasNext()) {
                entry2 = (Map.Entry) iterator2.next();

                dataset.setValue(Double.parseDouble(entry2.getValue().toString()), //每次统计数量
                        entry2.getKey().toString(),                                 //名称
                        entry1.getKey().toString());                               //分类
                System.out.println("当前:----" + entry2.getKey().toString() + "---" +
                        entry2.getValue().toString() + "--" +
                        entry1.getKey().toString());
            }
            System.out.println("------------------------------");


        }


        //创建柱状图，
        //柱状图分水平和竖直两种
        JFreeChart chart = ChartFactory.createBarChart(title, type, danwei, dataset, PlotOrientation.VERTICAL, true,
                true, true);

        //设置整个图片的标题字体
        chart.getTitle().setFont(font);


        //设置提示字体条
        font = new Font("宋体", Font.BOLD, 15);

        chart.getLegend().setItemFont(font);

        //得到绘图区域

        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        //得到绘图区的两个轴，设置标签字体
        plot.getDomainAxis().setLabelFont(font);


        //设置横轴标签字体
        plot.getDomainAxis().setTickLabelFont(font);

        //设置范围轴字体
        plot.getRangeAxis().setLabelFont(font);


        //设置chart背景图片

        try {

            chart.setBackgroundImage(ImageIO.read(new File("src/com/image/5.png")));

            plot.setBackgroundImage(ImageIO.read(new File("src/com/image/4.png")));

            plot.setForegroundAlpha(1.0f);

            ChartUtilities.saveChartAsJPEG(new File("src/com/image/3.png"), chart, 600, 400);


        } catch (IOException i) {
            System.out.println("背景文件图片IO有问题！！！");
        }


    }

}

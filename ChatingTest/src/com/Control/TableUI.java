package com.Control;



import java.awt.*;

import javax.swing.*;

import static com.Sort.SortFather.MessageMap;
import static com.Sort.SortFather.doubleMap;

/**
 * 此类用于绘制表格
 */
public class TableUI extends JFrame {
    private JTable table;
    private JLabel label;

    public TableUI() {
        super();
        setTitle("操作表格");// 窗体名称
        setBounds(920, 100, 400, 600);// 窗体大小
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();

        String[] columnNames = { "排序方法", "排序时间", "交换次数",  };// 定义表格列
        String[][] tableValues = new String[10][columnNames.length];// 定义数组，用来存储表格数据

        tableValues[0][0] = columnNames[0];// 给表格赋值
        tableValues[0][1] = columnNames[1];// 给表格赋值
        tableValues[0][2] = columnNames[2];// 给表格赋值

        label = new JLabel();

        int i = 1;
        for (String key  :MessageMap.keySet()) {
            String  re =MessageMap.get(key);
            tableValues[i][0] = key;
            String [] temp =MessageMap.get(key).split("#");
            tableValues[i][1] = doubleMap.get(key)+"";
            tableValues[i][2] = MessageMap.get(key);
            i++;
            if(i>=MessageMap.size()+1) break;

        }

//                for (int column = 0; column < columnNames.length; column++) {
//                    tableValues[row][column] = columnNames[column] + row;// 给表格赋值
//        }
        JTable table = new JTable(tableValues, columnNames);
        JScrollPane sc = new JScrollPane(table);


        int width = 400,height = 350;	//这是图片和JLable的宽度和高度
        ImageIcon image = new ImageIcon("src/com/image/3.png");//实例化ImageIcon 对象
        /*下面这句意思是：得到此图标的 Image（image.getImage()）；
        在此基础上创建它的缩放版本，缩放版本的宽度，高度与JLble一致（getScaledInstance(width, height,Image.SCALE_DEFAULT )）
        最后该图像就设置为得到的缩放版本（image.setImage）
        */
        image.setImage(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT ));//可以用下面三句代码来代替
        //Image img = image.getImage();
        //img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        //image.setImage(img);


        label.setIcon(image);

        c.add(table, BorderLayout.CENTER);
        c.add(label,BorderLayout.AFTER_LAST_LINE);

        table.setSelectionForeground(Color.RED);// 设置前景色，字体颜色
        table.setBackground(Color.PINK);
        table.setSelectionBackground(Color.yellow);// 背景色
        table.setRowHeight(30);// 设置行高30像素
        /*
         * ListSelectionModel.SINGLE_SELECTION 单选
         */
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 选择模式

        System.out.println("表格共有" + table.getRowCount() + "行" + table.getColumnCount() + "列");

    }

}




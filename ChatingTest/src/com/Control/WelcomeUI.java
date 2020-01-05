package com.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class WelcomeUI {

    private JFrame frame;
    private JButton button;
    private int width;
    private int height;
    private String title;
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenu menu2;
    private JMenuItem menuFace2;
    private JMenuItem menuFace3;
    private JMenuItem menuFace4;
    private JMenuItem menuInfo;


    public WelcomeUI(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        init(this.title,this.width,this.height);

    }

    public void init(String title,int width,int height){
        frame = new JFrame(title);
        button = new JButton("开始程序");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainUI mainUI = new MainUI("主界面");
            }
        });

        /**
         * 创建一个菜单栏
         */
        menuBar = new JMenuBar();

        menu1 = new JMenu("更换皮肤");
        menu2 = new JMenu("关于");
        menuFace2 = new JMenuItem("红");
        menuFace3 = new JMenuItem("黄");
        menuFace4 = new JMenuItem("绿");
        menuInfo = new JMenuItem("关于程序");

        menuInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameInfo = new JFrame("关于程序");
                JLabel label = new JLabel();
                frameInfo.setBounds(WelcomeUI.getWindowLocationX(300),WelcomeUI.getWindowLocationY(200),300,200);
                label.setBounds(0,0,300,200);
                label.setOpaque(true);
                label.setBackground(Color.LIGHT_GRAY);


//                JPanel jPanel1=new Jpanel();//new一个Jpanel
//                BorderLayout bb=new BorderLayout();  //边界布局，设置控件垂直居中
//                jPanel1.setLayout(bb);
//                jLabel1.setHorizontalAlignment(SwingConstants.CENTER);  //设置控件左右居中
                label.setFont(new java.awt.Font("黑体",1,12));//设置字体为黑体，字体大小为12，1代表样式(1是粗体，0是平常的
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setText("作者：tyq\t著作权：tyq");


//                label.setForeground(Color.red);//设置字体颜色
                /**
                 * 设置窗口大小禁止拖动
                 */
                frameInfo.add(label);
                frameInfo.setResizable(false);
                frameInfo.setLayout(null);
                frameInfo.setVisible(true);

            }
        });
        frame.setBounds(getWindowLocationX(width),getWindowLocationY(height),width,height);
        frame.setVisible(true);
        frame.add(button);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menu1.add(menuFace2);
        menu1.add(menuFace3);
        menu1.add(menuFace4);
        menu2.add(menuInfo);
        frame.add(menuBar);
        frame.setLayout(null);
        frame.addComponentListener(new ComponentAdapter() {//拖动窗口监听
            public void componentResized(ComponentEvent e) {
                int wwidth=frame.getWidth();//获取窗口宽度
                int wheight=frame.getHeight();//获取窗口高度  你也可以设置高度居中

                System.out.println("窗口的大小为"+wwidth+"x"+wheight);
                button.setBounds(0,0,wwidth,wheight-22);

            }

        });

    }


    /**
     * 获取屏幕尺寸
     */
    public static Dimension dimension =Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * 获取窗口在屏幕中的位置
     * @return
     */
    public static int getWindowLocationX(int width){
        return (dimension.width-width)/2;
    }
    public static int getWindowLocationY(int height){
        return (dimension.height- height)/2;
    }


    public static Container getLocation(JFrame frame){
        Container container  = frame.getContentPane();
        return container;
    }

}

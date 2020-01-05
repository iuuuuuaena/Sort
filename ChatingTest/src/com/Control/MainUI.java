package com.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MainUI {

    private JFrame frame;
    //button：发送按钮
    private JButton button;
    //规则按钮
    private JLabel rule;
    private JTextArea textArea;
    private JLabel label;
    private JScrollPane scrollPane;
    //设置滚动面板
    private String title;
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenu menu2;
    private JMenu remove;
    private JMenu setcount;
    private JMenuItem menuFace2;
    private JMenuItem menuFace3;
    private JMenuItem menuFace4;
    private JMenuItem menuFace5;
    private JMenuItem menuInfo;
    private JMenuItem removeALL;
    private JMenuItem count;
    private JPanel panel;

    private JButton button2;

    private static int Count;
    private int width;
    private int height;
    static int w  = 0;

    public enum m_Color {
        Red, Green, Blue
    }


    public MainUI(String title){
        this.width = 500;
        this.height = 400;
        this.title = title;
        init(this.title);
    }

    public void init(String title){

        frame  = new JFrame(title);
        frame.setVisible(true);
        button = new JButton("发送");
        button2 = new JButton("生成");
        label = new JLabel();
        rule  = new JLabel();
        panel = new JPanel();
        textArea = new JTextArea();
//        new Enum<m_Color>("Red",0);
//        new Enum<m_Color>("Green",1);
//        new Enum<m_Color>("Blue",2);

        /**滚动面板参数设置
         *      ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS  设置垂直滚动条always
         *      ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED 必要时出现
         *      ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER 不出现
         */
        scrollPane  = new JScrollPane(panel,22,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        /**
         * 创建一个菜单栏
         */
        menuBar = new JMenuBar();
        /**
         * 添加两个属性
         *      更换皮肤
         *      关于
         */
        menu1 = new JMenu("更换皮肤");
        menu2 = new JMenu("关于");
        remove = new JMenu("清除");
        setcount = new JMenu("测试数量");
        /**
         * 添加四个属性
         *
         */
        menuFace2 = new JMenuItem("红");
        menuFace2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rule.setBackground(Color.LIGHT_GRAY);
                label.setBackground(Color.red);
                textArea.setBackground(Color.red);
            }
        });
        menuFace3 = new JMenuItem("黄");
        menuFace3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rule.setBackground(Color.LIGHT_GRAY);
                label.setBackground(Color.yellow);
                textArea.setBackground(Color.yellow);
            }
        });
        menuFace4 = new JMenuItem("绿");
        menuFace4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rule.setBackground(Color.LIGHT_GRAY);
                label.setBackground(Color.green);
                textArea.setBackground(Color.green);
            }
        });
        menuFace5 = new JMenuItem("复原");

        menuFace5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rule.setBackground(Color.LIGHT_GRAY);
                textArea.setBackground(Color.pink);
                rule.setBackground(Color.GREEN);
                label.setBackground(Color.cyan);
            }
        });

        menuInfo = new JMenuItem("关于程序");
        removeALL = new JMenuItem("清屏");
        count = new JMenuItem("设置测试数量");


        menuInfo.addActionListener(new ActionListener() {
            /**
             * 帮助信息面板
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameInfo = new JFrame("关于程序");
                JLabel label1 = new JLabel();
                frameInfo.setBounds(WelcomeUI.getWindowLocationX(300),WelcomeUI.getWindowLocationY(200),300,200);
                Container container = WelcomeUI.getLocation(frameInfo);
                Dimension dimension = container.getSize();
                System.out.println("信息窗口大小为"+frameInfo.getWidth()+"x"+frameInfo.getHeight());
                label1.setBounds(0,0,frameInfo.getWidth(),frameInfo.getWidth());
                label1.setOpaque(true);
                label1.setBackground(Color.LIGHT_GRAY);


//                JPanel jPanel1=new Jpanel();//new一个Jpanel
//                BorderLayout bb=new BorderLayout();  //边界布局，设置控件垂直居中
//                jPanel1.setLayout(bb);
//                jLabel1.setHorizontalAlignment(SwingConstants.CENTER);  //设置控件左右居中
                label1.setFont(new java.awt.Font("黑体",1,12));//设置字体为黑体，字体大小为12，1代表样式(1是粗体，0是平常的
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setText("<html>作者：tyq<br>QQ:123456789</html>");
//                label.setForeground(Color.red);//设置字体颜色
                /**
                 * 设置窗口大小禁止拖动
                 */
                frameInfo.add(label1);
                frameInfo.setResizable(false);
                frameInfo.setLayout(null);
                frameInfo.setVisible(true);

            }
        });

        count.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameCount = new JFrame();
                JButton setcount = new JButton("确定");
                JTextField textField = new JTextField();
                textField.setBounds(0,0,110,30);
                setcount.setBounds(0,30,110,30);
                setcount.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /**
                         * 判断是否为数字
                         */
                       if(isNumeric(textField.getText())){
                           Count = Integer.parseInt(textField.getText());
                           JOptionPane.showMessageDialog(frameCount,"OK！","成功",1);
                           frameCount.setVisible(false);
                       }else {
                           /**
                            * 不是数字就警告
                            */
                           JOptionPane.showMessageDialog(frameCount,"只能为数字","警告",1);
                       }
                    }
                });
                frameCount.setBounds(WelcomeUI.getWindowLocationX(100),WelcomeUI.getWindowLocationY(70),110,80);
                frameCount.add(setcount);
                frameCount.add(textField);
                frameCount.setLayout(null);
                frameCount.setResizable(false);
                frameCount.setVisible(true);

            }
        });


        frame.setBounds(WelcomeUI.getWindowLocationX(this.width),WelcomeUI.getWindowLocationY(this.height),this.width,this.height);
        frame.add(button);
        frame.add(button2);
        frame.add(label);
        frame.add(rule);
        frame.add(textArea);
        frame.add(menuBar);
        frame.add(scrollPane);
        ////把菜单栏放在顶层容器
        frame.setJMenuBar(menuBar);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(remove);
        menuBar.add(setcount);
        menu1.add(menuFace2);
        menu1.add(menuFace3);
        menu1.add(menuFace4);
        menu1.add(menuFace5);
        menu2.add(menuInfo);
        remove.add(removeALL);
        setcount.add(count);

        frame.setLayout(null);



        textArea.setBounds(10,270,345,80);
        button.setBounds(357,303,56,40);
        button2.setBounds(429,303,56,40);
        rule.setBounds(355,10,135,360);
//                label.setBounds(10,10,7*(dimension.width/10)-5,4*dimension.height/5-20);


        scrollPane.setBounds(10,10,345,260);
        panel.setBounds(10,10,325,2000);
        /**
         * 窗口兼听事件，窗口拖动，控件也拖动
         */



        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int wwidth = frame.getWidth();
                int wheight =frame.getHeight();
                Container container = WelcomeUI.getLocation(frame);
                Dimension dimension = container.getSize();
                System.out.println("1主窗口大小为"+dimension.width+"x"+dimension.height);
                System.out.println("2主窗口大小为"+wwidth+"x"+wheight);
//                textArea.setBounds(10,4*wheight/5-30,7*(wwidth/10)-5,wheight/5);
//                rule.setBounds(7*wwidth/10+5,10,3*(wwidth/10)-15,wheight-40);w
//                label.setBounds(10,10,7*(wwidth/10)-5,4*wheight/5-30);
                textArea.setBounds(10,4*dimension.height/5-10,7*(dimension.width/10)-5,dimension.height/5);
                rule.setBounds(7*dimension.width/10+5,10,3*(dimension.width/10)-15,dimension.height-20);
//                label.setBounds(10,10,7*(dimension.width/10)-5,4*dimension.height/5-20);
                button.setBounds(35*dimension.width/48,9*dimension.height/11,dimension.width/9,dimension.height/10);
                button2.setBounds(41*dimension.width/48,9*dimension.height/11,dimension.width/9,dimension.height/10);

                scrollPane.setBounds(10,10,7*(dimension.width/10)-5,4*dimension.height/5-20);
                panel.setBounds(10,10,7*(dimension.width/10)-25,2000);
                System.out.println("w的值变为："+w);

            }

        });



        /**
         * 按钮监听事件：发送信息，显示在JScrollpane的panel的新增的label上
         */
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String time = sdf.format(new Date());


                JLabel label1 = new JLabel("", 4);
                label1.setText("<html>" + time + "<br>" + text + "<br></html>");
                textArea.setText("");
                label1.setOpaque(true);
                label1.setBackground(Color.LIGHT_GRAY);
                label1.setBounds(0, 130 * w, panel.getWidth(), 50);

//
//                    frame.addComponentListener(new ComponentAdapter() {
//                        @Override
//                        public void componentShown(ComponentEvent e) {
//                            Container container = WelcomeUI.getLocation(frame);
//                            Dimension dimension = container.getSize();
//                            System.out.println("1主窗口大小为" + dimension.width + "x" + dimension.height);
//                            label1.setSize(7 * (dimension.width / 10) - 25, 50);
//                        }
//                    });

                System.out.println("label的长为：" + panel.getWidth() + "宽为:" + panel.getHeight());
                label1.setBackground(Color.LIGHT_GRAY);
                panel.setLayout(null);
                panel.setSize(500, 500 * w);
                panel.setBackground(Color.yellow);
                System.out.println("w变为：" + w);
                panel.add(label1);
                panel.revalidate();
                panel.repaint();

                scrollPane.updateUI();

                /**
                 * 定义自动回复label
                 *      2：意思是文字靠左 ，同JLabel.LEFT
                 *      4: 意思是文字靠右 ,同JLabel.RIGHT
                 */
                JLabel label2 = new JLabel("", 2);
                /**
                 * 设置返回值
                 */
                Control control = new Control(text, Count);
                /**
                 * 进行判断
                 */
                String re = control.router();
                /**
                 * 开始绘图
                 */
                control.printChart();
                label2.setText("<html>" + time + "<br>" + re + "</html");
                /**
                 * 设置label透明
                 */
                label2.setOpaque(true);
                label2.setBackground(Color.cyan);
                label2.setBounds(0, 130 * w + 50, panel.getWidth(), 80);
                try {
                    /**
                     * 线程停顿一秒
                     */
                    Thread.sleep(500);
                } catch (InterruptedException i) {
                    System.out.println("线程的问题！！");
                }
                panel.add(label2);
                /**
                 * 设定每次点击发送按钮，清空textarea
                 */
                w++;


            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableUI frame = new TableUI();
                frame.setVisible(true);
            }
        });

        textArea.setBackground(Color.pink);

        /**这一步很关键，这一步设置label为透明，才能设置背景颜色*/
        label.setOpaque(true);
        scrollPane.setBackground(Color.orange);

        scrollPane.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                Dimension dim = new Dimension(scrollPane.getSize().width
                        -scrollPane.getVerticalScrollBar().getWidth()// 尺寸改变后可能会出现垂直滚动条，需减去其宽度

                        ,(int)(scrollPane.getSize().height+w*50));
                Dimension dimension = new Dimension(panel.getWidth(),panel.getHeight()+w*50);

                panel.setPreferredSize(dimension);     // 不设置此属性，ui会自动计算并设置
                panel.updateUI();
                scrollPane.updateUI();
            }
        });

        label.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension dimension = new Dimension(panel.getWidth(),panel.getHeight()+w*50);
                scrollPane.setPreferredSize(dimension);
                scrollPane.updateUI();
            }
        });
        rule.setFont(new java.awt.Font("黑体",1,14));//设置字体为黑体，字体大小为12，1代表样式(1是粗体，0是平常的
        rule.setHorizontalAlignment(SwingConstants.CENTER);
        rule.setText("<html>输入规则<br>1.冒泡排序<br>2.插入排序<br>3.选择排序<br>4.快速排序<br>5.希尔排序<br>6.归并排序</html>");
        rule.setOpaque(true);
        /**给label设置背景颜色*/
        rule.setBackground(Color.GREEN);
        label.setBackground(Color.cyan);
//        scrollPane.setBackground(Color.BLUE);

        /**
         * 使用jscrollpane的方法
         *     滚动面板。JScrollPane 支持水平和垂直滚动视图。
         *     文本区域、表格等需要显示较多数据而空间又有限时，
         *     通常使用 JScrollPane 进行包裹以实现滚动显示。
         *
         * 构造方法
         *     /**
         *   参数说明:
         *       view: 需要滚动显示的视图组件
         *       vsbPolicy: 垂直滚动条的显示策略
         *       hsbPolicy: 水平滚动条的显示策略
         *
         *      JScrollPane()
         *      JScrollPane(Component view)
         *      JScrollPane(Component view, int vsbPolicy, int hsbPolicy)
         *      JScrollPane( int vsbPolicy, int hsbPolicy)
         */


        frame.validate();
        //2.设置关闭窗口就是关闭程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        removeALL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.repaint();
                w = 0;
            }
        });

    }
    /**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }


}


//
//                panel.addComponentListener(new java.awt.event.ComponentAdapter() {
//                    public void componentResized(java.awt.event.ComponentEvent evt) {
//                        // 建议用同步线程，防止尺寸改变时出现同步问题和界面卡顿
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                resizeButtonIcon();
//                            }
//                            private synchronized void resizeButtonIcon(){
//                            }
//
//                        }).Start();
//                        panel.updateUI();
//                    }
//                });


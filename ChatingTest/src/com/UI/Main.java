package com.UI;

import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    private JFrame frame;
    private JButton button;
    private JTextArea textArea;
    private JLabel label;
    private JPanel panel;
    private int width;
    private int height;
    Font myfont = new Font("宋体",Font.BOLD,14);


    private Color selfMessageColor = new Color(230, 230, 230);
    private Color selfMessageBorderColor = new Color(198, 198, 198);


    private static final String STORE_PATH = "src/sourse/image/2.png";
    private static final String TEMPLATE_PATH = "src/sourse/image/1.png";


    public Main() {
        init();

    }

    public void init() {
        width = 500;
        height = 400;
        frame = new JFrame("TCP聊天程序");
        button = new JButton("点我");
        ImageIcon pic1 = new ImageIcon("1.png");
        label = new JLabel(pic1);
        textArea = new JTextArea();
        panel = new JPanel() {
            //序列号（可省略）
            private static final long serialVersionUID = 1L;

            // 重写paint方法
            @Override
            public void paint(Graphics graphics) {
                // 必须先调用父类的paint方法
                super.paint(graphics);
                Graphics2D g2D = (Graphics2D) graphics;
                // 用画笔Graphics，在画板JPanel上画一个小人
//                graphics.drawOval(100, 70, 30, 30);// 头部（画圆形）
//                graphics.drawRect(105, 100, 20, 30);// 身体（画矩形）
//                graphics.drawLine(105, 100, 75, 120);// 左臂（画直线）
//                graphics.drawLine(125, 100, 150, 120);// 右臂（画直线）
//                graphics.drawLine(105, 130, 75, 150);// 左腿（画直线）
//                graphics.drawLine(125, 130, 150, 150);// 右腿（画直线）


                int xPoints[] = new int[3];
                int yPoints[] = new int[3];
                // 绘制自己消息圆角消息气泡矩形
                g2D.setColor(selfMessageColor);
                g2D.fillRoundRect(50, 50, 100, 50, 10, 10);
                // 绘制圆角消息气泡边框
                g2D.setColor(selfMessageBorderColor);
                g2D.drawRoundRect(50, 50, 100, 50, 10, 10);

//                // 消息发出者是自己，则头像靠右显示
//                xPoints[0] = 50;
//                yPoints[0] = 50;
//                xPoints[1] = 150;
//                yPoints[1] = 50;
//                xPoints[2] = 150;
//                yPoints[2] = 100;
//
//                g2D.setColor(selfMessageColor);
//                //fileRolygon填充封闭多边形
//                g2D.fillPolygon(xPoints, yPoints, 3);
//                g2D.setColor(selfMessageBorderColor);
//                g2D.drawPolyline(xPoints, yPoints, 3);
//                g2D.setColor(selfMessageColor);
//
//                g2D.drawLine(xPoints[0], yPoints[0] + 1, xPoints[2], yPoints[2] - 1);

            }
        };


        frame.setBounds(getLocationX(width), getLocationY(height), width, height);

        Container container = getLocation(frame);

        Dimension dimension = container.getSize();

        panel.setBounds(10, 10, 480, 300);
        textArea.setBackground(Color.pink);

        button.setBounds(200, 350, 100, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage image = new BufferedImage(260, 80, BufferedImage.TYPE_INT_BGR);
//获取Graphics2D对象
                Graphics2D graphics = image.createGraphics();
//开启文字抗锯齿
                graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//设置字体
                Font font = new Font("Algerian", Font.ITALIC, 40);
                graphics.setFont(font);
//向画板上写字
                graphics.drawString("This is SortFather!", 10, 60);
                graphics.dispose();

            }
        });
        frame.add(button);
        frame.add(label);
        frame.add(textArea);
        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);


    }
//
////    但是对于JFrame和JDialog，可以通过getContentPane()获取窗口的主面板，然后获得。
//    Container contentPane=frame.getContentPane();
//    // 注意只有窗口显示后getLocationOnScreen才可以调用，否则出错
//    Point contentPos = contentPane.getLocationOnScreen();// 在屏幕的坐标
//    Dimension size = contentPane.getSize(); // 可视区域的大小


    public static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * 获取当前窗口的
     *
     * @param width
     * @return
     */
    public static int getLocationX(int width) {
        return (dimension.width - width) / 2;

    }

    public static int getLocationY(int height) {
        return (dimension.height - height) / 2;

    }

    /**
     * 获取当前的窗口的container
     *
     * @param frame
     * @return
     */
    public static Container getLocation(JFrame frame) {
        Container container = frame.getContentPane();
        return container;

    }

    public static void print() throws IOException {
        long start = System.currentTimeMillis();

        BufferedImage image = ImageIO.read(new File(TEMPLATE_PATH));

        // create graphics
        Graphics2D graphics = image.createGraphics();

        // set graphics profile
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);

        // draw circular
        graphics.setPaint(Color.BLUE);
        graphics.drawArc(200, 200, 200, 200, 90, 450 - 30);
        graphics.fillArc(200, 200, 200, 200, 90, 450 - 30);

        // draw sector
        graphics.setPaint(Color.RED);
        graphics.drawArc(200, 200, 200, 200, 90 - 30, 30);
        graphics.fillArc(200, 200, 200, 200, 90 - 30, 30);


        // store and end
        graphics.dispose();
        ImageIO.write(image, "PNG", new File(STORE_PATH));

        System.out.println(System.currentTimeMillis() - start);

    }
//
//    @Override
//    public void paintComponent(Graphics g) {
//        Graphics2D g2D = (Graphics2D) g;
//        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 反锯齿平滑绘制
//
//        // 通过对并发消息链表遍历绘制全部消息气泡、消息发出者头像
//        if (messageConcurrentLinkedQueue != null) {
//            Iterator<Message> iterator = messageConcurrentLinkedQueue.iterator();
//            while (iterator.hasNext()) {
//                Message message = iterator.next();
//
//                Point point = message.getMessagePaintLeftTop();
//
//                if (point != null) {
//                    // 绘制消息发出者头像
//                    if (senderHeadImageConcurrentHashMap != null) {
//                        Image image = senderHeadImageConcurrentHashMap.get(message.getSenderHeadImageID());
//                        if (image != null) {
//                            if (message.isSelfSender()) {
//                                g2D.drawImage(image, this.getWidth() - image.getWidth(null) - 9, point.y - 25, null);
//                            } else {
//                                // 消息发出者是别人，则头像靠左显示
//                                g2D.drawImage(image, 9, point.y - 25, null);
//                            }
//                        }
//                    }
//
//                    // 绘制额消息气泡左边小箭头
//                    int xPoints[] = new int[3];
//                    int yPoints[] = new int[3];
//
//                    if (message.isSelfSender()) {
//                        // 绘制自己消息圆角消息气泡矩形
//                        g2D.setColor(selfMessageColor);
//                        g2D.fillRoundRect(point.x - 7, point.y - 7, message.getMessagePaintWidth() + 14, message.getMessagePaintHeight() + 14, 10, 10);
//                        // 绘制圆角消息气泡边框
//                        g2D.setColor(selfMessageBorderColor);
//                        g2D.drawRoundRect(point.x - 7, point.y - 7, message.getMessagePaintWidth() + 14, message.getMessagePaintHeight() + 14, 10, 10);
//
//                        // 消息发出者是自己，则头像靠右显示
//                        xPoints[0] = (point.x - 7) + (message.getMessagePaintWidth() + 14);
//                        yPoints[0] = point.y;
//                        xPoints[1] = xPoints[0] + 7;
//                        yPoints[1] = point.y;
//                        xPoints[2] = xPoints[0];
//                        yPoints[2] = point.y + 7;
//
//                        g2D.setColor(selfMessageColor);
//                        g2D.fillPolygon(xPoints, yPoints, 3);
//                        g2D.setColor(selfMessageBorderColor);
//                        g2D.drawPolyline(xPoints, yPoints, 3);
//                        g2D.setColor(selfMessageColor);
//                        g2D.drawLine(xPoints[0], yPoints[0] + 1, xPoints[2], yPoints[2] - 1);
//                    } else {
//                        // 绘制别人消息圆角消息气泡矩形
//                        // 绘制圆角消息气泡矩形
//                        g2D.setColor(otherMessageColor);
//                        g2D.fillRoundRect(point.x - 7, point.y - 7, message.getMessagePaintWidth() + 14, message.getMessagePaintHeight() + 14, 10, 10);
//                        // 绘制圆角消息气泡边框
//                        g2D.setColor(otherMessageBorderColor);
//                        g2D.drawRoundRect(point.x - 7, point.y - 7, message.getMessagePaintWidth() + 14, message.getMessagePaintHeight() + 14, 10, 10);
//
//                        // 消息发出者是别人，则头像靠左显示
//                        xPoints[0] = point.x - 7;
//                        yPoints[0] = point.y;
//                        xPoints[1] = xPoints[0] - 7;
//                        yPoints[1] = point.y;
//                        xPoints[2] = xPoints[0];
//                        yPoints[2] = point.y + 7;
//
//                        g2D.setColor(otherMessageColor);
//                        g2D.fillPolygon(xPoints, yPoints, 3);
//                        g2D.setColor(otherMessageBorderColor);
//                        g2D.drawPolyline(xPoints, yPoints, 3);
//                        g2D.setColor(otherMessageColor);
//                        g2D.drawLine(xPoints[0], yPoints[0] + 1, xPoints[2], yPoints[2] - 1);
//                    }
//                }
//            } // while
//        }
//
//        super.paintComponent(g); // 执行默认组件绘制（消息文本、图片以及段落显示等内容）
//    }
//


    /**
     * 计算使用字体的一段字符串的宽
     *
     * @param font
     * @param content
     * @return
     */
    public static int getWordWidth(Font font, String content) {

        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int width = 0;
        for (int i = 0; i < content.length(); i++) {
            width += metrics.charWidth(content.charAt(i));
        }
        return width;
    }

    /**
     * 计算使用字体的一段字符串的高
     * @param font
     * @return
     */
    public static int getWordHeight(Font font) {

        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        return  metrics.getHeight();
    }
}

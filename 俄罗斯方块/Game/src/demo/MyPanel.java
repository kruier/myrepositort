package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MyPanel extends JPanel implements KeyListener, ActionListener {

    // 声明右侧蛇头和身体图片
    ImageIcon right = new ImageIcon("images/right.png");
    ImageIcon body = new ImageIcon("images/body.png");
    // 声明上、下、左侧蛇头图片
    ImageIcon top = new ImageIcon("images/top.png");
    ImageIcon bottom = new ImageIcon("images/bottom.png");
    ImageIcon left = new ImageIcon("images/left.png");

    // 声明一个初始值，表示蛇的长度为3
    int len = 3;
    // 声明两个数组分别存放x和y坐标的位置
    int[] snakeX = new int[1008]; // 最大值 = 宽度格子 * 高度格子;
    int[] snakeY = new int[1008]; // 最大值 = 宽度格子 * 高度格子;

    // 声明一个枚举类型变量，标识蛇头方向
    Direction direction = Direction.right;

    // 声明一个变量，标记游戏是否开始，当值为true表示开始游戏，否则没有开始游戏
    boolean isStart = false;
    boolean Dead = false;

    // 创建一个定时器对象
    Timer timer = new Timer(100, this);

    // 声明两个变量表示食物的坐标位置
    int foodX;
    int foodY;
    // 声明一个随机变量random
    Random random = new Random();
    // 声明食物图片
    ImageIcon food = new ImageIcon("images/food.png");

    public MyPanel() {
        // 设定蛇的头部和身体的初始位置
        snakeX[0] = 100;
        snakeY[0] = 100;
        snakeX[1] = 75;
        snakeY[1] = 100;
        snakeX[2] = 50;
        snakeY[2] = 100;

        // 获取键盘事件
        this.setFocusable(true);
        // 添加监听
        this.addKeyListener(this);

        // 启动定时器
        timer.start();

        // 生成食物的坐标
        foodX = 25 + 25 * random.nextInt(20);
        foodY = 25 + 25 * random.nextInt(20);
    }

    // 重写画组件的方法
    @Override
    protected void paintComponent(Graphics g) {
        // 调用父类方法做一些基本工作
        super.paintComponent(g);
        // 设置背景颜色
        this.setBackground(Color.red);
        // 在画布上添加游戏区域
        g.fillRect(0, 0, 700, 900);

        // 添加右侧蛇头
        // right.paintIcon(this, g, snakeX[0],snakeY[0]);
        // 根据枚举变量方向值，进行判断，显示哪个方向的蛇头
        switch (direction) {
            case top:
                top.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case bottom:
                bottom.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case left:
                left.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case right:
                right.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
        }

        // 添加两个身体
        /*
         * body.paintIcon(this, g, 75, 100);
         * body.paintIcon(this, g, 50, 100);
         */
        for (int i = 1; i < len; i++) {
            body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        // 判断当前标记游戏是否开始的值isStart如果为false则显示提示信息
        if (!isStart) {
            // 放上开始提示信息，并设置字体颜色和字体
            g.setColor(Color.white);
            g.setFont(new Font("宋体", Font.BOLD, 50));
            g.drawString("请按空格键表示游戏开始!", 50, 500);
        }
        if (Dead) {
            // 放上开始提示信息，并设置字体颜色和字体

            g.setColor(Color.white);
            g.setFont(new Font("宋体", Font.BOLD, 50));
            g.drawString("您已经死亡 按空格重试", 50, 500);
        }

        // 添加食物
        food.paintIcon(this, g, foodX, foodY);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // 判断，当按空格键时数字值应该为32
        if (keyCode == 32) {
            // 标记游戏状态的值取反
            isStart = !isStart;
            // 重新画组件
            repaint();
        } else if (keyCode == KeyEvent.VK_UP) {
            direction = Direction.top;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            direction = Direction.bottom;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            direction = Direction.left;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            direction = Direction.right;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 死亡 重新开始游戏
        if (Dead) {
            direction = Direction.right;
            Dead = !Dead;
            len = 3;
            isStart = !isStart;
            // 设定蛇的头部和身体的初始位置
            snakeX[0] = 100;
            snakeY[0] = 100;
            snakeX[1] = 75;
            snakeY[1] = 100;
            snakeX[2] = 50;
            snakeY[2] = 100;
        }

        if (isStart) {

            // 移动身体
            for (int i = len - 1; i > 0; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }

            // 通过方向值direction进行判断，移动蛇头
            switch (direction) {

                case top:
                    // 垂直向上移动
                    snakeY[0] -= 25;

                    if (snakeY[0] <= 0) {
                        snakeY[0] = 900;
                    }
                    for (int c = 1; c <= len; c++) {
                        if (snakeX[0] == snakeX[c]) {
                            if (snakeY[0] == snakeY[c]) {
                                Dead = !Dead;
                            }
                        }
                    }
                    break;
                case bottom:
                    // 垂直向下移动
                    snakeY[0] += 25;
                    if (snakeY[0] >= 900) {
                        snakeY[0] = 0;
                    }
                    for (int c = 1; c <= len; c++) {
                        if (snakeX[0] == snakeX[c]) {
                            if (snakeY[0] == snakeY[c]) {
                                Dead = !Dead;
                            }
                        }
                    }
                    break;
                case left:

                    // 水平向左移动
                    snakeX[0] -= 25;
                    if (snakeX[0] <= 0) {
                        snakeX[0] = 700;
                    }
                    for (int c = 1; c <= len; c++) {
                        if (snakeX[0] == snakeX[c]) {
                            if (snakeY[0] == snakeY[c]) {
                                Dead = !Dead;
                            }
                        }
                    }
                    break;
                case right:
                    // 假如蛇是水平向右移动，则蛇头的值+ 25
                    snakeX[0] += 25;
                    // 判断当前蛇头的值如果超出700，则x值再从0开始
                    if (snakeX[0] >= 700) {
                        snakeX[0] = 0;
                    }
                    for (int c = 1; c <= len; c++) {
                        if (snakeX[0] == snakeX[c]) {
                            if (snakeY[0] == snakeY[c]) {
                                Dead = !Dead;
                            }
                        }
                    }
                    break;
            }

            // 判断，当蛇头x和食物坐标x一致，并且蛇头y和食物坐标y一致，则表示吃到食物
            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                // 蛇的长度加1
                len++;
                // 重新生成食物的坐标位置
                foodX = 25 + 25 * random.nextInt(20);
                foodY = 25 + 25 * random.nextInt(20);
            }

            // 重新画组件方法
            repaint();
            // 重新启动定时器
            timer.start();
        }

    }

}

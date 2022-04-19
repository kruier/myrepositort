package demo;

import javax.swing.*;
import java.awt.*;

public class MySnake {
    public static void main(String[] args) {
        //创建一个窗口
        JFrame frame = new JFrame();
        //指定窗口x和y的位置以及窗口的宽度和高度值
        frame.setBounds(600, 100, 700, 900);
        //不允许拖拽改变大小
        frame.setResizable(false);
        //当点击窗口关闭按钮，执行操作是退出
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //添加画布
        frame.add(new MyPanel());
        //显示出来
        frame.setVisible(true);
    }
}

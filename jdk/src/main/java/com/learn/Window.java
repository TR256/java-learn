package com.learn;

import javax.swing.*;
import java.awt.*;

/**
 * @author MengXH
 * @date 2024/1/8
 */
public class Window {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        Dimension dimension = new Dimension(720, 640);
        jFrame.setSize(dimension);
        Dimension screenDimension = ToolkitUtil.getScreenDimension();
        jFrame.setLocation((int) (screenDimension.getWidth() - dimension.getWidth()) / 2, (int) (screenDimension.getHeight() - dimension.getHeight()) / 2);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

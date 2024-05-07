package com.learn;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author MengXH
 * @date 2024/1/8
 */
public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel(BufferedImage image) {
        super();
        this.image = image;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

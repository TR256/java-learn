package com.learn;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author MengXH
 * @date 2024/1/8
 */
public class ScreenCapture {

    private final static ScreenCapture screenCapture = new ScreenCapture();

    private Robot robot = null;

    private Rectangle rectangle = null;

    private ScreenCapture() {
        try {
            this.robot = new Robot();
            Dimension dimension = ToolkitUtil.getScreenDimension();
            this.rectangle = new Rectangle(dimension.width, dimension.height);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedImage capture() {
        return ScreenCapture.screenCapture.robot.createScreenCapture(ScreenCapture.screenCapture.rectangle);
    }
}

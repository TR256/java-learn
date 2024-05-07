package com.learn;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;

/**
 * @author MengXH
 * @date 2024/1/8
 */
public class RobotClass {


    public static void main(String[] args) throws AWTException, IOException {

        Robot robot = new Robot();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();


        Rectangle rectangle = new Rectangle((int) dimension.getWidth(), (int) dimension.getHeight());

        BufferedImage bufferedImage = robot.createScreenCapture(rectangle);

        File file = new File("E:/file.png");


        BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(file.toPath()));

        ImageIO.write(bufferedImage, "png", bos);



    }
}

package com.learn;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world!
 */
public class ImageTest {


    public static void main(String[] args) {
        Path path = Paths.get("E:/animal.jpg");
        BufferedImage image = ImageFileUtils.get(path);
        BufferedImage threshImage = ImageUtils.getThreshImage(image);
        ImageFileUtils.save(threshImage, Paths.get("E:/thresh-reverse.png"));
    }
}

package com.learn;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author MengXH
 * @date 2024/1/9
 */
public class OCRTest {

    public static void main(String[] args) throws IOException {
        long time0 = System.currentTimeMillis();
        BufferedImage image = ImageIO.read(new File("E:/test.jpg"));
        String text = OcrUtil.doOcr(image);
        System.out.println(text);
        long time1 = System.currentTimeMillis();
        System.out.println(time1- time0);
        String text1 = OcrUtil.doOcr(image);
        System.out.println(text1);
        long time2 = System.currentTimeMillis();
        System.out.println(time2- time1);
        String text2 = OcrUtil.doOcr(image);
        System.out.println(text2);
        long time3 = System.currentTimeMillis();
        System.out.println(time3- time2);
    }
}

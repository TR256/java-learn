package com.learn;

import java.awt.image.BufferedImage;

/**
 * 图像处理工具类
 *
 * @author MengXH
 * @date 2024/1/9
 */
public abstract class ImageUtils {


    /**
     * 获取Red通道图
     *
     * @param image 原图像
     * @return Red通道图
     */
    public static BufferedImage getRedChannelImage(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int rgb = image.getRGB(col, row);
                int redRgb = ((rgb >>> 16) << 16);
                newImage.setRGB(col, row, redRgb);
            }
        }
        return newImage;
    }

    /**
     * 获取Green通道图
     *
     * @param image 原图像
     * @return Green通道图
     */
    public static BufferedImage getGreenChannelImage(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int rgb = image.getRGB(col, row);
                int alpha = (rgb >>> 24);
                int green = (rgb << 16) >>> 24;
                int greenRgb = (alpha << 24) | (green << 8);
                newImage.setRGB(col, row, greenRgb);
            }
        }
        return newImage;
    }

    /**
     * 获取Blue通道图
     *
     * @param image 原图像
     * @return 获取Blue通道图
     */
    public static BufferedImage getBlueChannelImage(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int rgb = image.getRGB(col, row);
                int alpha = (rgb >>> 24);
                int blue = (rgb << 24) >>> 24;
                int blueRgb = (alpha << 24) | blue;
                newImage.setRGB(col, row, blueRgb);
            }
        }
        return newImage;
    }

    /**
     * 获取二值化图像
     *
     * @param image 原图像
     * @return 二值化图像
     */
    public static BufferedImage getThreshImage(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int rgb = image.getRGB(col, row);
                int alpha = rgb >>> 24;
                int red = (rgb << 8) >>> 24;
                int green = (rgb << 16) >>> 24;
                int blue = (rgb << 24) >>> 24;
                int color = ~0;
                if ((red + green + blue) / 3 >= 125) {
                    color = (alpha << 24);
                }
                newImage.setRGB(col, row, color);
            }
        }
        return newImage;
    }


    /**
     * 获取灰色图像
     *
     * @param image 原图像
     * @return 灰度图像
     */
    public static BufferedImage getGrayImage(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int rgb = image.getRGB(col, row);
                int alpha = rgb >>> 24;
                int red = (rgb << 8) >>> 24;
                int green = (rgb << 16) >>> 24;
                int blue = (rgb << 24) >>> 24;
                int gray = (red + green + blue) / 3;
                int grayRgb = (alpha << 24) | (gray << 16) | (gray << 8) | gray;
                newImage.setRGB(col, row, grayRgb);
            }
        }
        return newImage;
    }

}

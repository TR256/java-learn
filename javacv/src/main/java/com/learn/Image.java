package com.learn;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

/**
 * @author MengXH
 * @date 2024/1/9
 */
public class Image {

    public static void main(String[] args) {

        // 加载图片
        Mat image = opencv_imgcodecs.imread("E:/test.jpg");

        // 转为灰度图片
        Mat grayImage = new Mat();
        opencv_imgproc.cvtColor(image, grayImage, opencv_imgproc.COLOR_BGR2GRAY);

        // 高斯模糊
        Mat blurredImage = new Mat();
        opencv_imgproc.GaussianBlur(grayImage, blurredImage, new Size(5, 5), 0);

        // 边缘检测
        Mat edgesImage = new Mat();
        opencv_imgproc.Canny(blurredImage, edgesImage, 50, 150);

        // 保存图片
        opencv_imgcodecs.imwrite("E:/gray.jpg", edgesImage);
    }
}

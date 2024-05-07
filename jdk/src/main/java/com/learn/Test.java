package com.learn;

import java.io.IOException;

/**
 * @author MengXH
 * @date 2024/1/8
 */
public class Test {

    public static void main(String[] args) throws IOException {

        CaptureThread captureThread = new CaptureThread();
        captureThread.activeCapture();
        captureThread.start();
    }
}

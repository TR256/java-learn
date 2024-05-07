package com.learn;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Time;
import java.util.UUID;

/**
 * @author MengXH
 * @date 2024/1/8
 */
public class CaptureThread extends Thread {

    private Boolean running = Boolean.FALSE;

    private Integer ftp = 30;

    @Override
    public void run() {
        while (true) {
            try {
                if (this.running) {
                    BufferedImage image = ScreenCapture.capture();
                    BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(new File("E:/capture-" + System.currentTimeMillis() + ".png").toPath()));
                    ImageIO.write(image, "png", bos);
                }
                sleep(this.ftp);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void activeCapture() {
        this.ftp = 30;
        this.running = Boolean.TRUE;
    }

    public void suspendCapture() {
        this.ftp = 1;
        this.running = Boolean.FALSE;
    }

    public void setFtp(Integer ftp) {
        this.ftp = (int) Math.floor(1000d / ftp);
    }
}

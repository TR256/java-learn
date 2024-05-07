package com.learn;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author MengXH
 * @date 2024/1/9
 */
public class ImageFileUtils {


    /**
     * 读取文件
     *
     * @param path
     * @return
     */
    public static BufferedImage get(Path path) {
        if (Files.notExists(path)) {
            throw new RuntimeException("文件不存在");
        }
        try {
            return ImageIO.read(path.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 保存文件
     *
     * @param image
     * @param path
     */
    public static void save(BufferedImage image, Path path) {
        Path folderPath = path.getParent();
        if (Files.notExists(folderPath)) {
            try {
                Files.createDirectories(folderPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        File file = path.toFile();
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.learn;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 * @author MengXH
 * @date 2024/1/9
 */
public abstract class OcrUtil {

    private static Tesseract tesseract;

    /**
     * 初始化Tesseract实例
     */
    private static void init() {
        if (Objects.isNull(tesseract)) {
            String location = OcrUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            if (location.startsWith("/")) {
                location = location.substring(1);
            }
            tesseract = new Tesseract();
            tesseract.setDatapath(location + "test_data");
            tesseract.setLanguage(OCRTypeEnum.MIX_CHI_SIM__ENG.getValue());
        }
    }

    /**
     * 识别图片
     *
     * @param img
     * @return
     */
    public static String doOcr(BufferedImage img) {
        OcrUtil.init();
        try {
            return tesseract.doOCR(img);
        } catch (TesseractException e) {
            throw new RuntimeException(e);
        }
    }
}

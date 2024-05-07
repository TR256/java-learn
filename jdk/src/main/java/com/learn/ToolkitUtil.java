package com.learn;

import java.awt.*;

/**
 * @author MengXH
 * @date 2024/1/8
 */
public class ToolkitUtil {

    public static Dimension getScreenDimension() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        return toolkit.getScreenSize();
    }
}

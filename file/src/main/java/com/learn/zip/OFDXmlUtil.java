package com.learn.zip;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author MengXH
 * @date 2024/4/18
 */
public class OFDXmlUtil {

    /**
     * @param ofdFilePath OFD文件路径
     * @param filename    需要解析的XML文件再OFD文件中的完整路径
     * @return OFD文件
     * @throws IOException
     */
    private static String getContent(Path ofdFilePath, String filename) {
        try {
            ZipFile zipFile = new ZipFile(ofdFilePath.toFile());
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            StringBuilder buffer = null;
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (filename.equals(entry.getName())) {
                    buffer = new StringBuilder();
                    InputStream is = zipFile.getInputStream(entry);
                    byte[] bytes = new byte[1024];
                    int len = -1;
                    while ((len = is.read(bytes)) != -1) {
                        String str = new String(bytes, 0, len);
                        buffer.append(str);
                    }
                    break;
                }
            }
            return buffer == null ? null : buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String getContent(ByteArrayInputStream bais, String filename) {
        try {
            ZipInputStream zis = new ZipInputStream(bais);
            StringBuilder buffer = null;
            ZipEntry entry = zis.getNextEntry();
            while (entry != null) {
                if (filename.equals(entry.getName())) {
                    buffer = new StringBuilder();
                    byte[] buf = new byte[1024];
                    int len = -1;
                    while ((len = zis.read(buf)) > 0) {
                        String str = new String(buf, 0, len);
                        buffer.append(str);
                    }
                    break;
                }
                entry = zis.getNextEntry();
            }

            return buffer == null ? null : buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * 读取OFD.XML文件
     *
     * @param ofdFilePath
     * @return
     */
    public static String getOFDXML(Path ofdFilePath) {
        return getContent(ofdFilePath, "OFD.xml");
    }

    /**
     * 读物HBZC.XML文件
     *
     * @param ofdFilePath
     * @return
     */
    public static String getHBZCXML(Path ofdFilePath) {
        return getContent(ofdFilePath, "Doc_0/Attachs/HBZC.xml");
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:/test.ofd");
        String hbzc = getHBZCXML(path);
        System.out.println(hbzc);

        System.out.println();
        System.out.println();

        String ofd = getOFDXML(path);
        System.out.println(ofd);
    }
}

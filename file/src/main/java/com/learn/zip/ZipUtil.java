package com.learn.zip;

import java.io.*;
import java.nio.file.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * @author MengXH
 * @date 2024/4/18
 */
public class ZipUtil {

    public static void compress(Path ofdFilePath) throws IOException {
        ZipFile zipFile = new ZipFile(ofdFilePath.toFile());
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            System.out.println(entry);
        }
    }

    public static String getContent(Path ofdFilePath, String filename) throws IOException {
        ZipFile zipFile = new ZipFile(ofdFilePath.toFile());
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        StringBuilder buffer = null;
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if ("OFD.xml".equals(entry.getName())) {
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
    }

    public static String getOFDXML(Path ofdFilePath) throws IOException {
        return getContent(ofdFilePath, "OFD.xml");
    }

    public static String getHBZCXML(Path ofdFilePath) throws IOException {
        return getContent(ofdFilePath, "Doc_0/Attachs/HBZC.xml");
    }

//            File file = new File("D:/example/", entry.getName());
//            if (!file.isDirectory()) {
//                if (!file.exists()) {
//                    new File(file.getParent()).mkdirs();
//                }
//                OutputStream os = new FileOutputStream(file);
//                BufferedOutputStream bos = new BufferedOutputStream(os);
//                byte[] bytes = new byte[1024];
//                int len = -1;
//                InputStream is = zipFile.getInputStream(entry);
//                while ((len = is.read(bytes)) != -1) {
//                    bos.write(bytes, 0, len);
//                }
//
//                bos.close();
//                os.close();
//
//                is.close();
//            }else {
//                if (!file.exists()){
//                    file.mkdirs();
//                }
//            }
//        }
//}


    public static void addFileToZip(Path zipFilePath, Path addFilePath) throws IOException {
        // 创建一个FileOutputStream，指向ZIP文件
        if (Files.notExists(zipFilePath)) {
            Files.createFile(zipFilePath);
        }
        OutputStream os = Files.newOutputStream(zipFilePath, StandardOpenOption.APPEND);
        ZipOutputStream zos = new ZipOutputStream(os);
        InputStream addFileIs = Files.newInputStream(addFilePath);
        String filename = addFilePath.getParent().relativize(addFilePath).toString();
        ZipEntry zipEntry = new ZipEntry(filename);
        zos.putNextEntry(zipEntry);
        byte[] buffer = new byte[1024];

        addFileIs.close();
        zos.closeEntry();
        zos.close();
    }

    public static void add() throws IOException {
        String zipFileName = "E:/example.zip"; // 已存在的ZIP文件
        String fileToAdd = "E:/模板文件.docx"; // 需要添加的文件
//        String fileToAdd = "E:/招标文件_24983.ofd";
        addFileToZip(Paths.get(zipFileName), Paths.get(fileToAdd));
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:/test.ofd");
        compress(path);
        String uncompress = getHBZCXML(path);
        System.out.println(uncompress);
    }
}

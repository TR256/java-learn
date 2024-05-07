package com.learn.info;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Objects;

/**
 * @author MengXH
 * @date 2024/1/10
 */
public class FileReader {


    private String absoluteLocation = null;

    /**
     * 初始化文件存储路径
     */
    private void config() {
        // 获取项目文件路径
        String location = FileReader.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        if (location.startsWith("/")) {
            location = location.substring(1);
        }
        // 生成供应商信息存储文件夹
        final String folder = location + "db/";
        if (Files.notExists(Paths.get(folder))) {
            try {
                // 创建文件夹
                Files.createDirectories(Paths.get(folder));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // 生成供应商信息存储文件路径
        this.absoluteLocation = folder;
    }

    public <T> Boolean save(T dto) {
        String table = dto.getClass().getSimpleName().toLowerCase();
        String location = this.absoluteLocation + table + ".yg";
        ObjectOutputStream oos = null;
        try {
            // 创建对象输出流
            oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(location)));
            // 写入对象信息
            oos.writeObject(dto);
            return Boolean.TRUE;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (!Objects.isNull(oos)) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return Boolean.FALSE;
    }


    public <T> T query(Class<? extends T> clazz) {
        String table = clazz.getSimpleName().toLowerCase();
        String location = this.absoluteLocation + table + ".yg";
        ObjectInputStream ois = null;
        try {
            // 创建对象输出流
            ois = new ObjectInputStream(Files.newInputStream(Paths.get(location)));
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (!Objects.isNull(ois)) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        throw new RuntimeException("读取信息失败");
    }


    public <T> Boolean saveInfo(T dto) {
        String table = dto.getClass().getSimpleName().toLowerCase();
        String location = this.absoluteLocation + table + ".yg";
        ObjectOutputStream oos = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            // 创建对象输出流
            oos = new ObjectOutputStream(bos);
            // 写入对象信息
            oos.writeObject(dto);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (!Objects.isNull(oos)) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            Files.write(Paths.get(location), Collections.singleton(bos.toString()), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Boolean.FALSE;
    }


    public static void main(String[] args) {

    }
}

package com.learn;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class App {
    public static void main(String[] args) throws IOException {
        String location = "http://www.baidu.com/s?wd=";
        location = location + "关键字";
        URL url = new URL(location);
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        //以流链的形式封装原始流，加入缓存提高IO效率
        BufferedInputStream bis = new BufferedInputStream(is);
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = bis.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, length));
        }
    }
}

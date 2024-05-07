package com.basis.seralize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author MengXH
 * @date 2024/1/9
 */
public class SerializeBeanTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Paths.get("serial-bean.bean");
        SerializeBean serializeBean = new SerializeBean();
        serializeBean.setId(1);
        serializeBean.setName("name");
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));
        oos.writeObject(serializeBean);

        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path.toFile().toPath()));
        // 读取供应商信息并返回
        SerializeBean bean = (SerializeBean) ois.readObject();
        System.out.println(bean);
    }
}

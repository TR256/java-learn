package com.learn;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlBean.class);

        Marshaller marshaller = jaxbContext.createMarshaller();

        XmlBean.XmlInnerBean xmlInnerBean = new XmlBean.XmlInnerBean();
        xmlInnerBean.setInnerBeanName("InnerBean");

        XmlBean.XmlInnerBean2 xmlInnerBean2 = new XmlBean.XmlInnerBean2();
        xmlInnerBean2.setInnerBeanName2("InnerBean");

        XmlBean xmlBean = new XmlBean("namespace", "XmlBean", xmlInnerBean, xmlInnerBean2);


        marshaller.marshal(xmlBean, new File("xml-bean.xml"));


        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        File file = new File("xml-bean.xml");
        FileInputStream fis = new FileInputStream(file);
        XmlBean bean = (XmlBean) unmarshaller.unmarshal(fis);
        System.out.println(bean);
    }
}

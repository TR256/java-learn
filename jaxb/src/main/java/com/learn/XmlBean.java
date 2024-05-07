package com.learn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.*;

/**
 * @author MengXH
 * @date 2024/1/8
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlType
@XmlRootElement(name = "XmlBean")
public class XmlBean {

    @XmlAttribute(name = "namespace")
    private String namespace;

    @XmlElement(name = "name")
    private String name;

    private XmlInnerBean xmlInnerBean;

    private XmlInnerBean2 xmlInnerBean2;

    public String getNamespace() {
        return namespace;
    }

    @XmlTransient
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    @XmlTransient
    public void setName(String name) {
        this.name = name;
    }

    public XmlInnerBean getXmlInnerBean() {
        return xmlInnerBean;
    }

    public void setXmlInnerBean(XmlInnerBean xmlInnerBean) {
        this.xmlInnerBean = xmlInnerBean;
    }

    public XmlInnerBean2 getXmlInnerBean2() {
        return xmlInnerBean2;
    }

    public void setXmlInnerBean2(XmlInnerBean2 xmlInnerBean2) {
        this.xmlInnerBean2 = xmlInnerBean2;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType
    @Data
    public static class XmlInnerBean {

        @XmlElement(name = "XmlInnerBean")
        protected String innerBeanName;

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType
    @Data
    public static class XmlInnerBean2 {

        @XmlElement(name = "XmlInnerBean2")
        protected String innerBeanName2;

    }
}

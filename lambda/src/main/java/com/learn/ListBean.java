package com.learn;

import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author MengXH
 * @date 2023/12/21
 */
@ToString
public class ListBean {

    @XmlElement(name = "InnerBean")
    private StaticInnerBean staticInnerBean;

    public StaticInnerBean getInnerBean() {
        return staticInnerBean;
    }

    public void setInnerBean(StaticInnerBean staticInnerBean) {
        this.staticInnerBean = staticInnerBean;
    }

    @ToString
    public static class StaticInnerBean{

        @XmlAttribute(name = "ID")
        private String Id;

        @XmlAttribute(name = "Name")
        private String Name;

        public String getID() {
            return Id;
        }

        public void setID(String id) {
            Id = id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }
    }
}

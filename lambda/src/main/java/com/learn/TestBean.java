package com.learn;

import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author MengXH
 * @date 2023/12/21
 */
@ToString
public class TestBean {

    @XmlElement(name = "List")
    private List<ListBean> beanList;

    @XmlAttribute(name = "UUID")
    private String uuid;

    @XmlAttribute(name = "ID")
    private String id;

    @XmlAttribute(name = "GroupName")
    private String groupName;

    public List<ListBean> getList() {
        return beanList;
    }

    public void setList(List<ListBean> list) {
        this.beanList = list;
    }

    public String getUUID() {
        return uuid;
    }

    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

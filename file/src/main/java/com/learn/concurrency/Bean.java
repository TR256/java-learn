package com.learn.concurrency;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author MengXH
 * @date 2024/1/26
 */
@XmlRootElement(name = "bean")
@Data
public class Bean {

    private String id;

    private String name;

    private String uuid;

    private String ok;

    private String test;

    private String abc;

    @XmlAttribute(name = "ID")
    public String getId() {
        return id;
    }

    @XmlAttribute(name = "NAME")
    public String getName() {
        return name;
    }

    @XmlAttribute(name = "UUID")
    public String getUuid() {
        return uuid;
    }

    public String getOk() {
        return ok;
    }

    public String getTest() {
        return test;
    }

    public String getAbc() {
        return abc;
    }
}

package com.learn;

/**
 * @author: tr256
 * @time: 2023/9/7
 */
public class EntityBean {
    private Integer id;

    private String name;

    private Boolean ok;

    public EntityBean() {
    }

    public EntityBean(Integer id, String name, Boolean ok) {
        this.id = id;
        this.name = name;
        this.ok = ok;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @Override
    public String toString() {
        return "EntityBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ok=" + ok +
                '}';
    }
}

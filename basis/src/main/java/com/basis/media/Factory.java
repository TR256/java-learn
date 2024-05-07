package com.basis.media;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: MengXH
 * @time: 2023/11/13
 * @description:
 */
public class Factory {

    private String businessId;
    private String businessType;

    public Factory(String businessId, String businessType) {
        this.businessId = businessId;
        this.businessType = businessType;
    }

    private Set<Component> componentList = new HashSet<>();


    private void accept(Component newComponent) {
        for (Component component : componentList) {
            component.accept(newComponent);
        }
    }

    public AComponment createA() {
        AComponment aComponment = new AComponment(this);
        accept(aComponment);
        componentList.add(aComponment);
        return aComponment;
    }

    public BComponment createB() {
        BComponment bComponment = new BComponment(this);
        accept(bComponment);
        componentList.add(bComponment);
        return bComponment;
    }
}

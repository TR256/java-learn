package com.basis.media;

/**
 * @author: MengXH
 * @time: 2023/11/13
 * @description:
 */
public abstract class Component {

    private Factory factory;

    public Component(Factory factory) {
        this.factory = factory;
    }

    public abstract void accept(Component component);

}

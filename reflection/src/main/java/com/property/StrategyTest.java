package com.property;

import java.lang.reflect.Proxy;

/**
 * @author MengXH
 * @date 2023/11/28
 */
public class StrategyTest {

    public static void main(String[] args) {


        StrategyProxy<IStrategy> proxy = new StrategyProxy<>(IStrategy.class);
        IStrategy strategy = proxy.getInstance();
        strategy.agent();
    }
}

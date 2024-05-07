package com.basis.media;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: MengXH
 * @time: 2023/11/13
 * @description:
 */
public class AComponment extends Component {

    private Map<String, Object> map = new HashMap<>();

    public AComponment(Factory factory) {
        super(factory);
    }

    @Override
    public void accept(Component component) {

    }

    public void set(String key, Object value) {
        this.map.put(key, value);
    }

    public Object get(String key) {
        return this.map.get(key);
    }
}

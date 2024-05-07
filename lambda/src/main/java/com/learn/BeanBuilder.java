package com.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author: tr256
 * @time: 2023/10/16
 */
public class BeanBuilder<T> {

    /**
     *
     */
    private final Supplier<T> constructor;

    /**
     * 消费
     */
    private final List<Consumer<T>> consumerList = new ArrayList<>();

    public BeanBuilder(Supplier<T> constructor) {
        this.constructor = constructor;
    }

    public static <T> BeanBuilder<T> Builder(Supplier<T> constructor) {
        return new BeanBuilder<>(constructor);
    }

    public <P> BeanBuilder<T> set(BeanBuilder.Inject<T, P> consumer, P p) {
        Consumer<T> a = instance -> consumer.accept(instance, p);
        consumerList.add(a);
        return this;
    }

    public T build() {
        T instance = this.constructor.get();
        for (Consumer<T> consumer : consumerList) {
            consumer.accept(instance);
        }
        return instance;
    }

    public interface Inject<T, P> {
        /**
         *
         * @param t
         * @param p
         */
        void accept(T t, P p);
    }
}

package fun;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author MengXH
 * @date 2024/1/3
 */
public class FunctionTest {

    public static void consume(Consumer<String> consumer){
        consumer.accept("ok");
    }

    public static void supply(Supplier<String> supplier){
        System.out.println(supplier.get());
    }
    public static void main(String[] args) {
        consume(FunBean::consume);

        supply(FunBean::supply);
    }
}

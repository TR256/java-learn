package fun;

import java.util.function.Consumer;

/**
 * @author MengXH
 * @date 2024/1/3
 */
public class FunBean {

    public static void consume(String str) {
        System.out.println(str);
    }

    public static String supply() {
        return "SDK";
    }
}

/**
 * @author: tr256
 * @time: 2023/9/16
 */
public class Test {
    public static void testLambda(IFunctionTest test) {

        System.out.println(test.value());

    }

    public static void main(String[] args) {

        testLambda(()-> "OK");
    }
}

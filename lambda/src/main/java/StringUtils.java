/**
 * @author: MengXH
 * @time: 2023/10/24
 * @description:
 */
public class StringUtils {

    public static Boolean isEmpty(String str) {
        if (str == null) {
            return Boolean.TRUE;
        }
        if ("".equals(str.trim())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static Boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}

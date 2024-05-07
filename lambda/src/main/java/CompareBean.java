/**
 * @author: MengXH
 * @time: 2023/10/24
 * @description:
 */
public class CompareBean<T> {
    private Integer similar;

    private T bean;

    public CompareBean(Integer similar, T bean) {
        this.similar = similar;
        this.bean = bean;
    }

    @Override
    public String toString() {
        return "CompareBean{" +
                "similar=" + similar +
                ", bean=" + bean +
                '}';
    }
}

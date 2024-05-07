

import java.util.*;

/**
 * @author: MengXH
 * @time: 2023/10/24
 * @description:
 */

class Bean {
    private String name;

    private String a;

    private String b;

    private String c;

    public Bean(String name, String a, String b, String c) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                '}';
    }
}

public class RemoveList {
    public static void main(String[] args) {


        List<Bean> beanList = new ArrayList<>();

        beanList.add(new Bean("key", null, null, null));
        beanList.add(new Bean("key", "主体机构B", "监管机构A", null));
        beanList.add(new Bean("key", "主体机构B", null, null));
        beanList.add(new Bean("key", "主体机构A", "监管机构A", null));

        Bean dto = new Bean("key", "主体机构A", "监管机构A", "交易中心");

        List<CompareBean<Bean>> compareBeanList = new ArrayList<>(beanList.size());

        for (Bean bean : beanList) {
            Integer similar = 0;
            if (StringUtils.isNotEmpty(bean.getA())) {
                if (bean.getA().equals(dto.getA())) {
                    similar++;
                } else {
                    similar = -100;
                    continue;
                }
            }
            if (StringUtils.isNotEmpty(bean.getB())) {
                if (bean.getB().equals(dto.getB())) {
                    similar++;
                } else {
                    similar = -100;
                    continue;
                }
            }
            if (StringUtils.isNotEmpty(bean.getC())) {
                if (bean.getC().equals(dto.getC())) {
                    similar++;
                } else {
                    similar = -100;
                    continue;
                }
            }
            compareBeanList.add(new CompareBean<>(similar, bean));
        }

        for (CompareBean<Bean> compareBean : compareBeanList) {
            System.out.println(compareBean);
        }

    }
}

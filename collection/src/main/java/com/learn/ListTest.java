package com.learn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class A {
    Integer index;
    String name;
    String value;
}

/**
 * @author MengXH
 * @date 2023/11/22
 */
public class ListTest {

    public static void main(String[] args) {

        List<A> aList = new ArrayList<>();
        aList.add(new A(1, "one", "ONE"));
        aList.add(new A(2, "two", "TWO"));

        List<A> bList = new ArrayList<>();
        bList.add(new A(null, "zero", "ZERO"));
        bList.add(new A(1, "one", "TWO--------"));

        Map<String, A> bMap = bList.stream().collect(Collectors.toMap(A::getName, b -> b, (v1, v2) -> v1));


        aList.add(0, bMap.get("zero"));

        for (int i = 1; i < aList.size(); i++) {
            A temp = aList.get(i);
            if (bMap.containsKey(temp.getName())){
                aList.set(i, bMap.get(temp.getName()));
            }

            System.out.println("iii");
        }


        for (A a : aList) {
            System.out.println(a);
        }
    }
}

package com.basis;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author MengXH
 * @date 2023/12/12
 */
public class NumberTest {

    public static void add(int index, Double[] darr, List<Double> list) {
        if (index < darr.length) {
            ArrayList<Double> newList = new ArrayList<>();
            for (Double aDouble : list) {
                newList.add(aDouble + 0);
                newList.add(aDouble + darr[index]);
            }
            list = newList;
        }
    }

//    public static void main(String[] args) {
//
//        Double[] darr = new Double[64];
//        darr[0] = 0.5;
//        for (int i = 1; i < 8; i++) {
//            darr[i] = darr[i - 1] / 2D;
//        }
//        for (int i = 0; i < 8; i++) {
//            System.out.println(darr[i]);
//        }
//        List<Double> list = new ArrayList<>();
//    }


    public static void main(String[] args) {
//        List<Double> list = Arrays.asList(1.28, 6.00, 2.00, 5.00, 3.50, 2.50, 3.50, 2.00);
//        Optional<Double> reduce = list.stream().reduce(Double::sum);
//        System.out.println(reduce.get());


        Double num = 9.888899D;
        System.out.println(num);
        System.out.println(new BigDecimal("9.888899"));
    }
}

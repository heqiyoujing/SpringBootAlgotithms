package spring.boot.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/7/11
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<Long>(Arrays.asList(90L));
        list.forEach(System.out::println);
    }
}

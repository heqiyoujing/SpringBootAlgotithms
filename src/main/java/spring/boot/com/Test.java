package spring.boot.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author: yiqq
 * @date: 2019/7/11
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Integer nane = 29;
        Integer nane1 = 29;
        System.out.println(nane==nane1);
        Integer me = new Integer(1);
        Integer me1 = new Integer(1);
        System.out.println(me==me1);
        nane = 22;
        System.out.println(nane);
        System.out.println(nane1);


        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(5);
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(100);
    }
}

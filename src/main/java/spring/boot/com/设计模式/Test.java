package spring.boot.com.设计模式;

import java.io.PrintStream;

/**
 * @author: yiqq
 * @date: 2019/1/9
 * @description:
 */
public class Test {
    public static void main(String[] args){
//        int a=4;
//        int b=5;
//        method(a,b);
//        System.out.println(a);
//        System.out.println(b);
    }
    public static void method(int a, int b) {
        PrintStream Sys = new PrintStream(System.out){
            @Override
            public void println(String x) {
                super.println("a="+a*100+", b="+b*100);
            }
        };
        System.setOut(Sys);
//        try {
//            System.setOut(new PrintStream(new FileOutputStream("D:\\a.txt")));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}


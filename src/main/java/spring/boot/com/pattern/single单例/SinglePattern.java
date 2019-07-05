package spring.boot.com.pattern.single单例;

/**
 * @author: yiqq
 * @date: 2019/1/10
 * @description: 饿汉式（静态常量），最常用
 */
public class SinglePattern {

    private SinglePattern(){}

    private static SinglePattern ins = new SinglePattern();

    public static SinglePattern getIns(){
        return ins;
    }

}

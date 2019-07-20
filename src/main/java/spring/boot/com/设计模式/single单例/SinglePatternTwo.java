package spring.boot.com.设计模式.single单例;

/**
 * @author: yiqq
 * @date: 2019/1/10
 * @description: 懒汉式（静态常量），最常用
 */
public class SinglePatternTwo {

    private SinglePatternTwo(){}

    private static SinglePatternTwo ins = null;

    public static SinglePatternTwo getIns(){
        if (ins == null) {
            ins = new SinglePatternTwo();
        }
        return ins;
    }

}

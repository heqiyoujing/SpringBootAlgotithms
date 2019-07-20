package spring.boot.com.设计模式.Adapter适配器.classAdapter;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:  类适配器：继承A实现B，所以既能访问A的方法，又能访问B的方法。
 * 适配器模式是将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的的类的兼容性问题。
 * 主要分三类：类的适配器模式、对象的适配器模式、接口的适配器模式。
 * https://blog.csdn.net/zhangkaixuan456/article/details/79970271
 */
public class AdapterPatternTest {
    public static void main(String[] args) {
        Targetable targetable = new Adapter();
        targetable.method1();
        targetable.method2();
    }
}

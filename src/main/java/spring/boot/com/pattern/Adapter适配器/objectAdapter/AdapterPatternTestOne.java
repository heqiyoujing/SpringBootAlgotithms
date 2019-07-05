package spring.boot.com.pattern.Adapter适配器.objectAdapter;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description: 对象适配器模式：实现B接口，传入C对象，在A接口的方法实现中使用对象C调用其来源于B接口的方法。
 * https://blog.csdn.net/zhangkaixuan456/article/details/79970271
 */
public class AdapterPatternTestOne {
    public static void main(String[] args) {
        Source source = new Source();
        Targetable targetable = new Wrapper(source);
        targetable.method1();
        targetable.method2();
    }
}

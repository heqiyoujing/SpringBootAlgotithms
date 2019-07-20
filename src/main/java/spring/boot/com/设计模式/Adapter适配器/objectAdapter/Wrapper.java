package spring.boot.com.设计模式.Adapter适配器.objectAdapter;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description: 实现B接口，传入C对象，在A接口的方法实现中使用对象C调用其来源于B接口的方法。
 */
public class Wrapper  implements Targetable{
    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("This is the targetable method...");
    }
}

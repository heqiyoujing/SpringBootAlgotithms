package spring.boot.com.设计模式.Adapter适配器.classAdapter;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description: 继承A实现B，所以既能访问A的方法，又能访问B的方法
 */
public class Adapter  extends Source implements Targetable{
    @Override
    public void method2() {
        System.out.println("This is the targetable method...");
    }
}

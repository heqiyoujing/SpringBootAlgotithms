package spring.boot.com.设计模式.Adapter适配器.classAdapter;

public interface Targetable {
    /**
     * 与原类中的方法相同
     */
    public void method1();

    /**
     * 新类的方法
     */
    public void method2();
}

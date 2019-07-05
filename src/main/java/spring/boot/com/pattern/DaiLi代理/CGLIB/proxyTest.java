package spring.boot.com.pattern.DaiLi代理.CGLIB;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description: CGLIB动态代理
 * https://blog.csdn.net/yhl_jxy/article/details/80633194
 */
public class proxyTest {
    public static void main(String[] args) {
        /**
         * CGLIB动态代理：
         * 1.指明一系列的接口来创建一个代理对象
         * 2.创建一个类实现MethodInterceptor，重写intercept方法，MethodProxy.invokeSuper(obj, params)
         * 3.给目标对象创建一个代理对象：利用Enhancer设置它的属性setSuperclass(代理对象)和setCallback(实现类)
         * 4.利用Enhancer创建对象
         * 5.调用对象的方法
         */
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(MyTarget.class);
//        enhancer.setCallback(new MyInterceptor());
//        MyTarget target = (MyTarget) enhancer.create();

        MyTarget target = new MyTarget();
        MyInterceptor interceptor = new MyInterceptor(target);
        target = (MyTarget)interceptor.getProxyInstance();
        target.printName();
        System.out.println("proxy class name:" + target.getClass().getName());
    }
}

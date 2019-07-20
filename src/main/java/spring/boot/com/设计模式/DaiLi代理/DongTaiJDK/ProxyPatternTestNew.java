package spring.boot.com.设计模式.DaiLi代理.DongTaiJDK;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: yiqq
 * @date: 2019/1/10
 * @description:
 */

/**
 * 创建动态代理对象的步骤：
 1. 指明一系列的接口来创建一个代理对象
 2. 创建一个调用处理器（InvocationHandler）对象
 3. 将这个代理指定为某个其他对象的代理对象
 4. 在调用处理器的invoke（）方法中采取代理，一方面将调用传递给真实对象，另一方面执行各种需要的操作
 */
public class ProxyPatternTestNew {
    public static void main(String[] args) {
        IService service = new Service();
        Class<? extends IService> clazz = service.getClass();

        IService proxyService = (IService) Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(), new ServiceInvocationHandler(service));

        //这里可以通过运行结果证明proxyService是Proxy的一个实例，这个实例实现了Subject接口
        System.out.println(proxyService instanceof Proxy);
        //这里可以看出proxyService的Class类是$Proxy0,这个$Proxy0类继承了Proxy，实现了proxyService接口
        System.out.println("proxyService的Class类是："+proxyService.getClass().toString());
        System.out.print("subject中的属性有：");

        Field[] field=proxyService.getClass().getDeclaredFields();
        for(Field f:field){
            System.out.print(f.getName()+", ");
        }

        System.out.print("\n"+"subject中的方法有：");

        Method[] method=proxyService.getClass().getDeclaredMethods();

        for(Method m:method){
            System.out.print(m.getName()+", ");
        }

        System.out.println("\n"+"subject的父类是："+proxyService.getClass().getSuperclass());

        System.out.print("\n"+"subject实现的接口是：");

        Class<?>[] interfaces=proxyService.getClass().getInterfaces();

        for(Class<?> i:interfaces){
            System.out.print(i.getName()+", ");
        }

        System.out.println("\n\n"+"运行结果为：");


        proxyService.service();
    }
}

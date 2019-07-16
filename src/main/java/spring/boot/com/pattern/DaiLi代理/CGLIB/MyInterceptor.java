package spring.boot.com.pattern.DaiLi代理.CGLIB;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:
 */
public class MyInterceptor implements MethodInterceptor {
    private Object target;

    public MyInterceptor (Object target){
        this.target=target;
    }

    // 给目标对象创建一个代理对象
    public Object getProxyInstance() {
        /*CGlib采用非常底层的字节码技术，可以为一个类创建子类，
        并在子类中采用方法拦截技术拦截父类方法的调用，并顺势进行增强，即是织入横切逻辑*/
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }

    /**
     *
     * @param obj 表示增强的对象，即实现这个接口类的一个对象；
     * @param method 表示要被拦截的方法；
     * @param params 表示要被拦截方法的参数；
     * @param proxy 表示要触发父类的方法对象；
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy) throws Throwable {
        System.err.println("=======before======");
        Object res = proxy.invokeSuper(obj, params);
        System.err.println("=======and======");
        return res;
    }
}

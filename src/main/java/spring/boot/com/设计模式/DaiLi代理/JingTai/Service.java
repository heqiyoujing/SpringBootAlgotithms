package spring.boot.com.设计模式.DaiLi代理.JingTai;

/**
 * @author: yiqq
 * @date: 2019/1/10
 * @description:
 */

/**
 * 被代理类
 */
public class Service implements IService{
    @Override
    public void service() {
        System.out.println("被代理对象执行相关操作");
    }
}

package spring.boot.com.设计模式.DaiLi代理.DongTaiJDK;

/**
 * @author: yiqq
 * @date: 2019/1/10
 * @description:
 */
public class Service implements IService{
    @Override
    public void service() {
        System.out.println("被代理对象执行相关操作");
    }
}

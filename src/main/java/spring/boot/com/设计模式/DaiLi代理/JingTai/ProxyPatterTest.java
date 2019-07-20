package spring.boot.com.设计模式.DaiLi代理.JingTai;

/**
 * @author: yiqq
 * @date: 2019/1/10
 * @description:
 */
public class ProxyPatterTest {
    public static void main(String[] args) {
        IService service = new Service();
        //传入被代理类的对象
        ProxyService proxyService = new ProxyService(service);
        proxyService.service();
    }
}

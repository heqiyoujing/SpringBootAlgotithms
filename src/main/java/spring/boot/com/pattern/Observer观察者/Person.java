package spring.boot.com.pattern.Observer观察者;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:
 */
public interface Person {
    //老王和老李通过这个接口可以接收到小美发过来的消息
    void getMessage(String s);
}

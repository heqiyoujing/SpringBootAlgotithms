package spring.boot.com.设计模式.Factory工厂.DuoGe;


import spring.boot.com.设计模式.Factory工厂.PuTongFactory.Sender;

/**
 * @author: yiqq
 * @date: 2019/1/10
 * @description:
 */
public class FactoryTest {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.prodcemail();
        sender.Send();
    }
}

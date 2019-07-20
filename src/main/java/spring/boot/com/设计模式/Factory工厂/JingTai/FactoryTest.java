package spring.boot.com.设计模式.Factory工厂.JingTai;


import spring.boot.com.设计模式.Factory工厂.PuTongFactory.Sender;

/**
 * @author: yiqq
 * @date: 2019/1/10
 * @description:
 */
public class FactoryTest {
    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.Send();
    }
}

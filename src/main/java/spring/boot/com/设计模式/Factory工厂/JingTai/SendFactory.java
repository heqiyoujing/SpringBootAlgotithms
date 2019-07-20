package spring.boot.com.设计模式.Factory工厂.JingTai;


import spring.boot.com.设计模式.Factory工厂.PuTongFactory.MailSender;
import spring.boot.com.设计模式.Factory工厂.PuTongFactory.Sender;
import spring.boot.com.设计模式.Factory工厂.PuTongFactory.SmsSender;

/**
 * @author: yiqq
 * @date: 2019/1/10
 * @description:
 */
public class SendFactory {
    public static Sender produceMail(){
        return new MailSender();
    }
    public static Sender produceSms(){
        return new SmsSender();
    }
}

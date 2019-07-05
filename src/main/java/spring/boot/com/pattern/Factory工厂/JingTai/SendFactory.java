package spring.boot.com.pattern.Factory工厂.JingTai;

import design.pattern.Factory工厂.PuTongFactory.MailSender;
import design.pattern.Factory工厂.PuTongFactory.Sender;
import design.pattern.Factory工厂.PuTongFactory.SmsSender;

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

package spring.boot.com.pattern.Factory工厂.DuoGe;

import spring.boot.com.pattern.Factory工厂.PuTongFactory.MailSender;
import spring.boot.com.pattern.Factory工厂.PuTongFactory.Sender;
import spring.boot.com.pattern.Factory工厂.PuTongFactory.SmsSender;

/**
 * @author: yiqq
 * @date: 2019/1/10
 * @description:
 */
public class SendFactory {
    public Sender prodcemail(){
        return new MailSender();
    }
    public Sender prodceSms(){
        return new SmsSender();
    }
}

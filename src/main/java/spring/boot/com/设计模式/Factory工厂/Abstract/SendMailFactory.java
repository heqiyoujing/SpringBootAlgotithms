package spring.boot.com.设计模式.Factory工厂.Abstract;

/**
 * @author: yiqq
 * @date: 2019/1/10
 * @description:
 */
public class SendMailFactory implements Provider{
    @Override
    public Sender produce(){
        return new MailSender();
    }
}

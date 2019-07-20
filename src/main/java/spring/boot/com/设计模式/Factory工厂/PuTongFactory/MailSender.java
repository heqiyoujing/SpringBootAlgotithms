package spring.boot.com.设计模式.Factory工厂.PuTongFactory;

/**
 * @author: yiqq
 * @date: 2019/1/10
 * @description:
 */
public class MailSender implements Sender{
    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }
}

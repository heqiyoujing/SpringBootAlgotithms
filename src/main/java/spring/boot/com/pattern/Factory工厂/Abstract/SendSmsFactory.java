package spring.boot.com.pattern.Factory工厂.Abstract;

/**
 * @author: yiqq
 * @date: 2019/1/10
 * @description:
 */
public class SendSmsFactory implements Provider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}

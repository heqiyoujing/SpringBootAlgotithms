package spring.boot.com.设计模式.Adapter适配器.interfaceAdapter;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description: 提供聊天服务 需要网络功能
 */
public class Chat  extends Wrapper{
    @Override
    public void NET() {
        System.out.println("Hello World...");
    }
}

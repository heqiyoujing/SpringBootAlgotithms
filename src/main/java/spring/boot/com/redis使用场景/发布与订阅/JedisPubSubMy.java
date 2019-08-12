package spring.boot.com.redis使用场景.发布与订阅;

import redis.clients.jedis.JedisPubSub;

/**
 * @author: yiqq
 * @date: 2019/8/5
 * @description:
 */
public class JedisPubSubMy extends JedisPubSub{

    // 当向监听的频道发送数据时，这个方法会被触发
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("收到消息" + message);
        //当收到 "unsubscribe" 消息时，调用取消订阅方法
        if ("unsubscribe".equals(message)) {
            this.unsubscribe();
        }
    }

    // 当取消订阅指定频道的时候，这个方法会被触发
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("取消订阅频道" + channel);
    }

}

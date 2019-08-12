package spring.boot.com.redis使用场景.发布与订阅;

import redis.clients.jedis.Jedis;
import spring.boot.com.redis使用场景.MyJedis;

/**
 * @author: yiqq
 * @date: 2019/8/5
 * @description:
 */
public class RedisSubTest {

    public static Jedis jedis = MyJedis.getJedisObject();

    public static void main(String[] args) {

        //发布者
        jedis.publish( "news.share", "新闻分享");
        jedis.publish( "news.blog", "新闻博客");

        //订阅者
        System.out.println("订阅者 ");
        JedisPubSubMy jedisPubSubMy = new JedisPubSubMy();
        jedis.subscribe(jedisPubSubMy, "news.share", "news.blog");

        //关闭连接
        jedis.close();
    }
}

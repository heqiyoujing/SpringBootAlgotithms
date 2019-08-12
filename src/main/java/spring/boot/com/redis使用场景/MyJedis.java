package spring.boot.com.redis使用场景;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author: yiqq
 * @date: 2019/8/5
 * @description:
 */
public class MyJedis {
    private static final Long UNLOCK_SUCCESS = 1L;
    private static JedisPool jedisPool = null;
    static {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        jedisPool = new JedisPool(config, "192.168.18.23", 6379, 6000, "123456");
    }

    public static Jedis getJedisObject(){
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static void recycleJedisObject(final Jedis jedis){
        if (jedis != null) {
            jedisPool.returnResourceObject(jedis);
        }
    }
}

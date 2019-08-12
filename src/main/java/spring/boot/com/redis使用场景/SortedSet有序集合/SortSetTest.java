package spring.boot.com.redis使用场景.SortedSet有序集合;

import redis.clients.jedis.Jedis;
import spring.boot.com.redis使用场景.MyJedis;

/**
 * @author: yiqq
 * @date: 2019/8/5
 * @description:
 */
public class SortSetTest {
    public static Jedis jedis = MyJedis.getJedisObject();
    public static Jedis shardedJedis = MyJedis.getJedisObject();
    public static void main(String[] args) {
        System.out.println("======================zset==========================");
        // 清空数据
        System.out.println(jedis.flushDB());

        System.out.println("=============增=============");
        System.out.println("zset中添加元素element001："+shardedJedis.zadd("zset", 7.0, "element001"));
        System.out.println("zset中添加元素element002："+shardedJedis.zadd("zset", 8.0, "element002"));
        System.out.println("zset中添加元素element003："+shardedJedis.zadd("zset", 2.0, "element003"));
        System.out.println("zset中添加元素element004："+shardedJedis.zadd("zset", 3.0, "element004"));
        System.out.println("zset集合中的所有元素："+shardedJedis.zrange("zset", 0, -1));//按照权重值排序
        System.out.println();

        System.out.println("=============删=============");
        System.out.println("zset中删除元素element002："+shardedJedis.zrem("zset", "element002"));
        System.out.println("zset集合中的所有元素："+shardedJedis.zrange("zset", 0, -1));
        System.out.println();

        System.out.println("=============改=============");
        System.out.println();

        System.out.println("=============查=============");
        System.out.println("统计zset集合中的元素中个数："+shardedJedis.zcard("zset"));
        System.out.println("统计zset集合中权重某个范围内（1.0——5.0），元素的个数："+shardedJedis.zcount("zset", 1.0, 5.0));
        System.out.println("查看zset集合中element004的权重："+shardedJedis.zscore("zset", "element004"));
        System.out.println("查看下标1到2范围内的元素值："+shardedJedis.zrange("zset", 1, 2));
    }
}

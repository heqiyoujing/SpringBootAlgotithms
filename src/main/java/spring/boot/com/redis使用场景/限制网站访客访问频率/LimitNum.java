package spring.boot.com.redis使用场景.限制网站访客访问频率;

import redis.clients.jedis.Jedis;
import spring.boot.com.redis使用场景.MyJedis;

/**
 * @author: yiqq
 * @date: 2019/8/5
 * @description:
 */
public class LimitNum {
    public static Jedis jedis = MyJedis.getJedisObject();

    public static void main(String[] args) {
        // 模拟用户的频繁请求
        for (int i = 0; i < 20; i++) {
            boolean result = testLogin("192.168.18.23");
            if (result) {
                System.out.println("正常访问");
            } else {
                System.err.println("访问受限");
            }
        }
    }

    public static boolean testLogin(String ip) {
        String value = jedis.get(ip);
        if (value == null) {
            //初始化时设置IP访问次数为1
            jedis.set(ip, "1");
            //设置IP的生存时间为60秒，60秒内IP的访问次数由程序控制
            jedis.expire(ip, 60);
//            jedis.set(ip, "1", "NX", "EX", 60);
        } else {
            int parseInt = Integer.parseInt(value);
            //如果60秒内IP的访问次数超过10，返回false,实现了超过10次禁止分的功能
            if (parseInt > 10) {
                return false;
            } else {
                //如果没有10次，可以自增
                jedis.incr(ip);
            }
        }
        return true;
    }
}

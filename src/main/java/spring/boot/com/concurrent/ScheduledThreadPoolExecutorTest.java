package spring.boot.com.concurrent;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: yiqq
 * @date: 2019/7/13
 * @description:
 * https://www.cnblogs.com/jinggod/p/8490223.html
 */
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException{
      /*  //池中只有一个线程
        ScheduledThreadPoolExecutor schedulePool = new ScheduledThreadPoolExecutor(1);
        //作为一个周期任务提交,period 为1000ms,任务执行时间为2000ms
        schedulePool.scheduleAtFixedRate(new MyRunnable(), 50, 1000, TimeUnit.MILLISECONDS);*/

        /*//池中只有一个线程
        ScheduledThreadPoolExecutor schedulePool = new ScheduledThreadPoolExecutor(1);
        //作为一个周期任务提交,delay 为1000ms
        schedulePool.scheduleWithFixedDelay(new MyRunnable(), 50, 1000, TimeUnit.MILLISECONDS);*/

        //池中只有一个线程
        ScheduledThreadPoolExecutor schedulePool = new ScheduledThreadPoolExecutor(1);
        //shutdown时，周期任务的策略
        schedulePool.setContinueExistingPeriodicTasksAfterShutdownPolicy(true);
        //作为周期任务提交
        ScheduledFuture future = schedulePool.scheduleWithFixedDelay(new MyRunnable(), 50, 1000, TimeUnit.MILLISECONDS);

        Thread.sleep(10*1000);

        schedulePool.shutdown();

    }

    static class MyRunnable implements Runnable {

        int period = 1;

        @Override
        public void run() {
            //为周期任务捕获异常，避免异常影响下一周期的任务执行
            try {
                System.out.println("---------------第 " + period + " 周期-------------");
                System.out.println("begin = " + System.currentTimeMillis() / 1000);//秒
                //任务执行时间
                Thread.sleep(2000);
                System.out.println("end =   " + System.currentTimeMillis() / 1000);
                period++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

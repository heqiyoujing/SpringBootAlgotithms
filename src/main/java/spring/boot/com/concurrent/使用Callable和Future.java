package spring.boot.com.concurrent;

import java.util.concurrent.*;

/**
 * @author: yiqq
 * @date: 2019/7/11
 * @description:
 * https://blog.csdn.net/m0_37840000/article/details/79756932  (创建线程的4种方式)
 * https://www.cnblogs.com/dolphin0520/p/3949310.html  （Java并发编程：Callable、Future和FutureTask）
 * http://www.threadworld.cn/archives/39.html   （Callable和Future简述）
 */
public class 使用Callable和Future {

    public static void main(String[] args) {
        /** Executors提供了一系列工厂方法用于创先线程池，返回的线程池都实现了ExecutorService接口。   */
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);

        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在进行计算");
            Thread.sleep(3000);
            int sum = 0;
            for(int i=0;i<100;i++)
                sum += i;
            return sum;
        }
    }
}
